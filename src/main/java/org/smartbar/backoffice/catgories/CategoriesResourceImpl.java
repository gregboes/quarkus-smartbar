package org.smartbar.backoffice.catgories;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.NonBlocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.smartbar.backoffice.model.ApiCategory;
import org.smartbar.backoffice.resources.CategoriesResource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CategoriesResourceImpl implements CategoriesResource {

    private final CategoriesService categoriesService;
    private final CategoryMapper mapper;

    @Inject
    public CategoriesResourceImpl(CategoriesService categoriesService, CategoryMapper mapper) {
        this.categoriesService = categoriesService;
        this.mapper = mapper;
    }

    @Blocking
    @Override
    public Response categoriesCategoryIdDelete(Long categoryId) {
        categoriesService.delete(categoryId);
        return Response.ok().build();
    }

    @Blocking
    @Override
    public ApiCategory categoriesCategoryIdGet(Long categoryId) {
        return mapper.toDto(categoriesService.findById(categoryId));
    }

    @Blocking
    @Override
    public Response categoriesCategoryIdPut(Long categoryId, ApiCategory apiCategory) {
        Category updatedCategory = new Category(apiCategory);
        updatedCategory.setId(categoryId);
        categoriesService.update(updatedCategory);
        return Response.ok().build();
    }

    @Blocking
    @Override
    public List<ApiCategory> categoriesGet() {
        return categoriesService.findAll()
            .stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }

    @Blocking
    @Override
    public Response categoriesPost(ApiCategory category) {
        Category newCategory = new Category(category);
        Category persistedCategory = categoriesService.persist(newCategory);
        return Response.created(
            URI.create("/categories/" + persistedCategory.getId())
        )
        .build();
    }
}

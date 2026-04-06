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

@ApplicationScoped
@NonBlocking
public class CategoriesResourceImpl implements CategoriesResource {

    @Inject
    private CategoriesService categoriesService;

    public CategoriesResourceImpl(CategoriesService categoriesService){
        this.categoriesService = categoriesService;
    }

    @Override
    public Response categoriesCategoryIdDelete(String categoryId) {
        return Response.noContent().build();
    }

    @Override
    public ApiCategory categoriesCategoryIdGet(String categoryId) {
        return new ApiCategory().name("Soft Drinks").description("Boissons sans alcool");
    }

    @Override
    public Response categoriesCategoryIdPut(String categoryId, ApiCategory category) {
        return Response.ok(category).build();
    }

    @Override
    public List<ApiCategory> categoriesGet() {
        return List.of();
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

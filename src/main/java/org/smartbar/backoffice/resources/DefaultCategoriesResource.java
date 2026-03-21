package org.smartbar.backoffice.resources;

import io.smallrye.common.annotation.NonBlocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.smartbar.backoffice.model.Category;


import java.util.List;

@NonBlocking
public class DefaultCategoriesResource implements CategoriesResource {

    @Override
    public Response categoriesCategoryIdDelete(String categoryId) {
        return Response.noContent().build();
    }

    @Override
    public Category categoriesCategoryIdGet(String categoryId) {
        return new Category().name("Soft Drinks").description("Boissons sans alcool");
    }

    @Override
    public Response categoriesCategoryIdPut(String categoryId, Category category) {
        return Response.ok(category).build();
    }

    @Override
    public List<Category> categoriesGet() {
        return List.of(
                new Category().name("Soft Drinks").description("Boissons sans alcool"),
                new Category().name("Cocktails").description("Boissons alcoolisées")
        );
    }

    @Override
    public Response categoriesPost(Category category) {
        return Response.status(Response.Status.CREATED).entity(category).build();
    }
}
package org.smartbar.backoffice.resources;

import jakarta.enterprise.context.ApplicationScoped;
import org.smartbar.backoffice.model.Article;
import org.smartbar.backoffice.model.Category;

@ApplicationScoped
public class CategoriesService {

    public Category get(){
        return new Category().name("Soft Drinks");
    }
}

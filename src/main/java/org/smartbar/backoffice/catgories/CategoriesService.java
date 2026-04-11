package org.smartbar.backoffice.catgories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.smartbar.backoffice.CrudService;
import org.smartbar.backoffice.model.ApiCategory;
import org.smartbar.backoffice.tables.Table;


@ApplicationScoped
public class CategoriesService extends CrudService<Category> {

    public CategoriesService(){
        // Just for CDI requirements
        super(null, null);
    }

    @Inject
    public CategoriesService(EntityManager entityManager) {
        super(entityManager, Category.class);
    }

}

package org.smartbar.backoffice.articles;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.smartbar.backoffice.CrudService;

@ApplicationScoped
public class ArticlesService extends CrudService<Article> {

    public ArticlesService(){
        // Just for CDI requirements
        super(null);
    }

    @Inject
    public ArticlesService(EntityManager entityManager) {
        super(entityManager);
    }

    public Article get(){
        return new Article();
    }
}

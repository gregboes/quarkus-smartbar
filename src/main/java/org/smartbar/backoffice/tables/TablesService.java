package org.smartbar.backoffice.tables;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.smartbar.backoffice.CrudService;


@ApplicationScoped
public class TablesService extends CrudService<Table> {

    public TablesService(){
        // Just for CDI requirements
        super(null, null);
    }

    @Inject
    public TablesService(EntityManager entityManager) {
        super(entityManager, Table.class);
    }

    public Table get(){
        return new Table();
    }
}

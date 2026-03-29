package org.smartbar.backoffice;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
public class CrudService<E> {

    private EntityManager entityManager;

    public CrudService(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public E persist(E entity){
        this.entityManager.persist(entity);
        this.entityManager.flush();
        return entity;
    }
}

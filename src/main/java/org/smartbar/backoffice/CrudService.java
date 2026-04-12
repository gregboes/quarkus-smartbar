package org.smartbar.backoffice;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@Transactional
public class CrudService<E> {

    private EntityManager entityManager;
    private Class<E> entityClass;


    @Inject
    public CrudService(
        EntityManager entityManager,
        Class<E> entityClass
        ){
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    private CriteriaBuilder getCb() {
        return entityManager.getCriteriaBuilder();
    }

    public E persist(E entity){
        this.entityManager.persist(entity);
        this.entityManager.flush();
        return entity;
    }

    public List<E> findAll() {
        // query = SELECT, Ce que doit retourner la query -> entityClass
        CriteriaQuery<E> query = getCb().createQuery(entityClass);
        // == FROM ...
        query.from(entityClass);
        return entityManager.createQuery(query).getResultList();
    }

    public E findById(Object id){
        E entity = entityManager.find(entityClass, id);
        if (entity == null) {
            throw new NotFoundException("Entity not found with id: " + id);
        }
        return entity;
    }

    public void delete(Object id) {
        E entity = entityManager.find(entityClass, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public E update(E entity) {
        // merge = si entité existe, update sinon insert
        return entityManager.merge(entity);
    }

    // Exemple de requete pour un getName
    public List<String> getNames() {
        CriteriaQuery<String> query = getCb().createQuery(String.class);
        Root<E> root = query.from(entityClass);
        query.select(root.get("name"));
        return entityManager.createQuery(query).getResultList();
    }

    public List<E> findByName(String name){
        // cb = boite a outil pour requetes
        // query = SELECT
        CriteriaQuery<E> query = getCb().createQuery(entityClass);
        // root désigne la table ex root.join
        Root<E> root = query.from(entityClass);
        query.where(getCb().equal(root.get("name"), name));
        return entityManager.createQuery(query).getResultList();
    }

}

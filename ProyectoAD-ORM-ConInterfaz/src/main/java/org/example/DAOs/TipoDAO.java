package org.example.DAOs;

import jakarta.persistence.EntityManager;
import org.example.modelo.Tipo;

import java.util.List;

public class TipoDAO implements DAO<Tipo, Integer> {
    private final EntityManager entityManager;

    public TipoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Tipo findById(Integer id) {
        return entityManager.find(Tipo.class, id);
    }

    @Override
    public List<Tipo> findAll() {
        return entityManager.createQuery("SELECT t FROM Tipo t", Tipo.class).getResultList();
    }

    @Override
    public void save(Tipo entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Tipo entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Tipo entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
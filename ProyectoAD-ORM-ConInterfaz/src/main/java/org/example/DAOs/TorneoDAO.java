package org.example.DAOs;

import jakarta.persistence.EntityManager;
import org.example.modelo.Torneo;

import java.util.List;

public class TorneoDAO implements DAO<Torneo, Integer> {
    private final EntityManager entityManager;

    public TorneoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Torneo findById(Integer id) {
        return entityManager.find(Torneo.class, id);
    }

    @Override
    public List<Torneo> findAll() {
        return entityManager.createQuery("SELECT t FROM Torneo t", Torneo.class).getResultList();
    }

    @Override
    public void save(Torneo entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Torneo entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Torneo entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
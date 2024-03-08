package org.example.DAOs;

import jakarta.persistence.EntityManager;
import org.example.modelo.Miembro;

import java.util.List;

public class MiembroDAO implements DAO<Miembro, Integer> {
    private final EntityManager entityManager;

    public MiembroDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Miembro findById(Integer id) {
        return entityManager.find(Miembro.class, id);
    }

    @Override
    public List<Miembro> findAll() {
        return entityManager.createQuery("SELECT m FROM Miembro m", Miembro.class).getResultList();
    }

    @Override
    public void save(Miembro entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Miembro entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Miembro entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
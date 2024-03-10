package org.example.DAOs;
import org.example.modelo.Inscripcion;

import jakarta.persistence.EntityManager;
import java.util.List;

public class InscripcionDAO implements DAO<Inscripcion, Integer> {
    private final EntityManager entityManager;

    public InscripcionDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Inscripcion findById(Integer id) {
        return entityManager.find(Inscripcion.class, id);
    }

    @Override
    public List<Inscripcion> findAll() {
        return entityManager.createQuery("SELECT i FROM Inscripcion i", Inscripcion.class).getResultList();
    }

    @Override
    public void save(Inscripcion entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Inscripcion entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Inscripcion entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
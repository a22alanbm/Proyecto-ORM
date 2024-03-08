package org.example.DAOs;

import javax.persistence.*;
import org.example.modelo.Equipo;
import java.util.List;

public class EquipoDAO implements DAO<Equipo, Integer>{
    private final EntityManager entityManager;

    public EquipoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Equipo findById(Integer id) {
        return entityManager.find(Equipo.class, id);
    }

    @Override
    public List<Equipo> findAll() {
        return entityManager.createQuery("SELECT e FROM Equipo e", Equipo.class).getResultList();
    }

    @Override
    public void save(Equipo entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Equipo entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Equipo entity) {

        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
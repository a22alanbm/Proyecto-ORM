package org.example.DAOs;

import java.util.List;

public interface DAO<T, ID> {
    T findById(ID id);

    List<T> findAll();

    void save(T entity);

    void update(T entity);

    void delete(T entity);
}
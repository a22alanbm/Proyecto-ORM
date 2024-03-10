package org.example.Connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class MyConnectionManager {

    private static MyConnectionManager myConnectionManager;
    private static EntityManager entityManager;

    private MyConnectionManager() {
        // Constructor privado para evitar la creación de instancias directas
    }

    public static synchronized MyConnectionManager getInstance() {
        if (myConnectionManager == null) {
            synchronized (MyConnectionManager.class) {
                if (myConnectionManager == null) {
                    myConnectionManager = new MyConnectionManager();
                }
            }
        }
        return myConnectionManager;
    }

    public synchronized EntityManager getManager(){

        if (entityManager == null) {
            synchronized (MyConnectionManager.class) {
                if (entityManager == null) {
                    entityManager = (EntityManager) Persistence.createEntityManagerFactory("GolfDB").createEntityManager();
                }
            }
        }

        return entityManager;
    }

}

package com.example.jakartapdponline.repository;

import com.example.jakartapdponline.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class AuthRepository {
    EntityManager em;

    public AuthRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orm");
        em = emf.createEntityManager();

    }

    public User getUserByUsername(String username) {
        em.getTransaction().begin();
        Query nativeQuery = em.createNativeQuery("select * from orm.users where username=?", User.class);
        nativeQuery.setParameter(1, username);
        User user = (User) nativeQuery.getSingleResult();
        em.getTransaction().commit();
        return user;
    }

    public void addUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }
}

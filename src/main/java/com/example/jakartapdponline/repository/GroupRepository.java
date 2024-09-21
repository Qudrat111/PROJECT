package com.example.jakartapdponline.repository;

import com.example.jakartapdponline.model.Group;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GroupRepository {
    EntityManager em;

    public GroupRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orm");
        em = emf.createEntityManager();
    }

    public void insertGroup(Group group) {
        em.getTransaction().begin();
        em.persist(group);
        em.getTransaction().commit();
    }

    public void updateGroup(int id, Group group) {
        em.getTransaction().begin();
        em.merge(group);
        em.getTransaction().commit();
    }

    public void deleteGroup(int id) {
        em.getTransaction().begin();
        em.remove(em.find(Group.class, id));
        em.getTransaction().commit();
    }

    public Optional<List<Group>> getAll() {
        em.getTransaction().begin();
        Query nativeQuery = em.createNativeQuery("select * from orm.groups", Group.class);
        ArrayList groups = new ArrayList<>(nativeQuery.getResultList());
        return Optional.of(groups);
    }
}
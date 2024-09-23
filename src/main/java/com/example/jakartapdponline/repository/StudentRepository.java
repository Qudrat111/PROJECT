package com.example.jakartapdponline.repository;

import com.example.jakartapdponline.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepository {
    private EntityManager em;

    public StudentRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orm");
        em = emf.createEntityManager();
    }

    public void insertStudent(Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }

    public void updateStudent(Integer studentId, Student student) {
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    public void deleteStudent(Integer studentId) {
        em.getTransaction().begin();
        Student student = em.find(Student.class, studentId);
        em.remove(student);
        em.getTransaction().commit();
    }

    public Optional<List<Student>> getStudents() {
        em.getTransaction().begin();
        List resultList = em.createNativeQuery("select * from orm.students", Student.class).getResultList();
        ArrayList students = new ArrayList<>(resultList);
        return Optional.ofNullable(students);
    }
}
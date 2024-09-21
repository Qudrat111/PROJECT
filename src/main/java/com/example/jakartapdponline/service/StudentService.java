package com.example.jakartapdponline.service;
import com.example.jakartapdponline.model.Student;
import com.example.jakartapdponline.repository.StudentRepository;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService() {
        studentRepository = new StudentRepository();
    }
    public void add(Student student) {
        student.setCreatedBy(student.getId() + 1);
        studentRepository.insertStudent(student);
    }
    public void update(Student student, Integer id) {
        student.setUpdatedBy(student.getId() + 1);
        student.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        studentRepository.updateStudent(id, student);
    }
    public void delete(Integer id) {
        studentRepository.deleteStudent(id);
    }
    public List<Student> getAll() {
        Optional<List<Student>> students = studentRepository.getStudents();
        return students.get();
    }
}
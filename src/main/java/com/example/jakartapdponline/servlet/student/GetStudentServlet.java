package com.example.jakartapdponline.servlet.student;

import com.example.jakartapdponline.model.Student;
import com.example.jakartapdponline.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/student/get")
public class GetStudentServlet extends HttpServlet {
    private StudentService service;

    public GetStudentServlet() {
        service = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = service.getAll();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/WEB-INF/students/get.jsp").forward(req, resp);
    }
}

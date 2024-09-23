package com.example.jakartapdponline.servlet.student;

import com.example.jakartapdponline.model.Student;
import com.example.jakartapdponline.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/student/create")
public class CreateStudentServlet extends HttpServlet {
    private StudentService service;

    public CreateStudentServlet() {
        service = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/students/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        student.setFullName(req.getParameter("fullName"));
        student.setUserName(req.getParameter("userName"));
        student.setDateOfBirth(Date.valueOf(req.getParameter("dateOfBirth")));
        student.setGroup_id(Integer.parseInt(req.getParameter("groupId")));
        service.add(student);
        resp.sendRedirect("/student/get");
    }
}

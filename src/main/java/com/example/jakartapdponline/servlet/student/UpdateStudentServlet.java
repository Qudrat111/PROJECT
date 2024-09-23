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

@WebServlet("/student/update")
public class UpdateStudentServlet extends HttpServlet {
    private StudentService service;

    public UpdateStudentServlet() {
        service = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("id", req.getParameter("id"));
        req.getRequestDispatcher("/WEB-INF/students/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        student.setFullName(req.getParameter("fullName"));
        student.setUserName(req.getParameter("userName"));
        student.setDateOfBirth(Date.valueOf(req.getParameter("dateOfBirth")));
        student.setGroup_id(Integer.parseInt(req.getParameter("groupId")));
        int id = Integer.parseInt(req.getParameter("id"));
        service.update(student, id);
        resp.sendRedirect("/student/get");
    }
}

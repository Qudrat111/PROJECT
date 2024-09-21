package com.example.jakartapdponline.servlets;

import com.example.jakartapdponline.model.User;
import com.example.jakartapdponline.repository.AuthRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final AuthRepository authRepository;

    public LoginServlet() {
        this.authRepository = new AuthRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User userByUsername = authRepository.getUserByUsername(username);
        if (userByUsername != null && userByUsername.getPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setMaxInactiveInterval(10);
            session.setAttribute("user_id", userByUsername.getUser_id());
            System.out.println(userByUsername.getUser_id());
        }
    }
}

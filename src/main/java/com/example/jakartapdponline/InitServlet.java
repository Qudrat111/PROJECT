package com.example.jakartapdponline;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        value = "/init_param",
        initParams = {
                @WebInitParam(
                        name = "db.user",
                        value = "postgres"
                ),
                @WebInitParam(
                        name = "db.password",
                        value = "1234"
                ),
                @WebInitParam(
                        name = "db.url",
                        value = "jdbc:postgresql://localhost:5432/pdp_online"
                )
        }
)
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String initParameter = getInitParameter("db.user");
        String password = getInitParameter("db.password");
        String url = getInitParameter("db.url");
        resp.getWriter().write("<h1>" + initParameter + "</h1>" + " " + "<h1>" + password + "</h1>" + " " + "<h1>" + url + "</h1>");
    }
}

package com.example.jakartapdponline;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet("/show")
public class FileShow extends HttpServlet {
    private final static Path rootPath = Path.of("C:\\Users\\Salim\\Desktop\\uploads");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File name = new File(rootPath.toString());
        if (name.isDirectory()) {
            String[] files = name.list();
            req.setAttribute("files", files);
            req.getRequestDispatcher("/WEB-INF/show.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String file = req.getParameter("file");
        byte[] bytes = Files.readAllBytes(rootPath.resolve(file));
        resp.getOutputStream().write(bytes);
    }
}

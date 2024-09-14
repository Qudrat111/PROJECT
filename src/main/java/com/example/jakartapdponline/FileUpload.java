package com.example.jakartapdponline;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@WebServlet("/upload")
@MultipartConfig()
public class FileUpload extends HttpServlet {
    private final static Path rootPath = Path.of("C:\\Users\\Salim\\Desktop\\uploads");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part file = req.getPart("file");
        String substring = file.getSubmittedFileName().substring(file.getSubmittedFileName().lastIndexOf("."));
        String newName = file.getSubmittedFileName();
        InputStream inputStream = file.getInputStream();
        Files.copy(inputStream, rootPath.resolve(newName), StandardCopyOption.REPLACE_EXISTING);
        resp.sendRedirect("/show");
    }
}

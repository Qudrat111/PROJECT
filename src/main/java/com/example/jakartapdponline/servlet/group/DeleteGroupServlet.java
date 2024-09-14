package com.example.jakartapdponline.servlet.group;

import com.example.jakartapdponline.service.GroupService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/group/delete")
public class DeleteGroupServlet extends HttpServlet {
    private GroupService groupService;

    public DeleteGroupServlet() {
        groupService = new GroupService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        groupService.delete(id);
        resp.sendRedirect("/group/get");
    }

}

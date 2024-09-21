package com.example.jakartapdponline.servlets.group;

import com.example.jakartapdponline.model.Group;
import com.example.jakartapdponline.service.GroupService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/group/update")
public class UpdateGroupServlet extends HttpServlet {
    private GroupService groupService;

    public UpdateGroupServlet() {
        groupService = new GroupService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("id", req.getParameter("id"));
        req.getRequestDispatcher("/WEB-INF/groups/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Group group = new Group();
        group.setName(req.getParameter("name"));
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        groupService.update(group, id);
        resp.sendRedirect("/group/get");
    }
}
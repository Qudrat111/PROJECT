package com.example.jakartapdponline.servlet.group;
import com.example.jakartapdponline.model.Group;
import com.example.jakartapdponline.service.GroupService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/group/create")
public class CreateGroupServlet extends HttpServlet {
    private GroupService groupService;
    public CreateGroupServlet() {
        this.groupService = new GroupService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/groups/create.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Group group = new Group();
        group.setName(req.getParameter("name"));
        groupService.save(group);
        resp.sendRedirect("/group/get");
    }
}
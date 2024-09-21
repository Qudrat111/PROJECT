package com.example.jakartapdponline.servlets.group;
import com.example.jakartapdponline.model.Group;
import com.example.jakartapdponline.service.GroupService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/group/get")
public class GetGroupServlet extends HttpServlet {
    private GroupService groupService;
    public GetGroupServlet() {
        groupService = new GroupService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Group> groups = groupService.getAll();
        req.setAttribute("groups", groups);
        req.getRequestDispatcher("/WEB-INF/groups/get.jsp").forward(req, resp);
    }
}
package com.infoshareacademy.servlets;

import com.infoshareacademy.dao.UsersRelationsBeanLocal;
import com.infoshareacademy.entities.Group;
import com.infoshareacademy.entities.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/userRelationsServlet")
public class UserRelationsServlet extends HttpServlet {

    @Inject
    UsersRelationsBeanLocal users;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Group group = users.findGroupByID(2);

        resp.getWriter().write("Users in group " + group.getName() + "\n");
        for(User u : group.getUsers()){
            resp.getWriter().write(u.getName() + "\n");
        }

        resp.getWriter().write(getClass().getName() + " OK!");
    }

}

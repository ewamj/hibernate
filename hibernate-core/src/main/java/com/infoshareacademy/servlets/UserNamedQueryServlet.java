package com.infoshareacademy.servlets;

import com.infoshareacademy.dao.UsersNamedQueryBeanLocal;
import com.infoshareacademy.entities.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/userNamedQueryServlet")
public class UserNamedQueryServlet extends HttpServlet {

    @Inject
    UsersNamedQueryBeanLocal users;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> usersList = users.getUser("Jan");
        Long count = (Long) users.getUsersCount("Jan");

        for (User u : usersList) {
            resp.getWriter().write(u.getName() + "\n");
        }
        resp.getWriter().write(count + "\n");

        resp.getWriter().write(getClass().getName() + " OK!");
    }

}

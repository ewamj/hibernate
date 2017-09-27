package com.infoshareacademy.servlets;

import com.infoshareacademy.dao.UsersJTABeanLocal;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/userJTAServlet")
public class UserJTAServlet extends HttpServlet {

    @Inject
    UsersJTABeanLocal users; // wstrzyknięcie interfejsu ejb, który będzie realizował

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("action") == null || req.getParameter("action").isEmpty() || req.getParameter("action").equals("add")) {
            users.addUser();
        } else if (req.getParameter("action").equals("update")) {
            users.updateUser(Integer.parseInt(req.getParameter("id")));
        }
        resp.getWriter().write(getClass().getName() + " OK!");
    }

}

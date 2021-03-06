package com.infoshareacademy.servlets;

import com.infoshareacademy.transactions.UsersRLBeanLocal;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/userRLServlet")
public class UserRLServlet extends HttpServlet {

    @Inject
    UsersRLBeanLocal users;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            users.addManyUsers();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        }
        resp.getWriter().write(getClass().getName() + " OK!");
    }

}

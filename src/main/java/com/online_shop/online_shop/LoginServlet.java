package com.online_shop.online_shop;

import javaBean.User;
import services.UserService;

import java.io.*;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService;

    public LoginServlet() {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("login.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Optional<User> user = this.userService.fetchUser(email, password);
        if (user.isPresent()) {
            this.redirectToHomePage(req, resp, user.get());
        } else {
            this.redirectToLoginPage(req, resp);
        }

    }

    private void redirectToHomePage(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        resp.sendRedirect(req.getContextPath()+"/");
    }

    private void redirectToLoginPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("login.jsp");
        HttpSession session = req.getSession();
        session.setAttribute("error", "Email or password not valid");
        view.forward(req, resp);
    }
}
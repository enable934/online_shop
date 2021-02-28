package com.online_shop.online_shop;

import javaBean.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "registrationServlet", value = "/register")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService;

    public RegistrationServlet() {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("register.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("passwordConfirm");
        String email = req.getParameter("email");
        this.validate(req,resp,"firstname",firstname);
        this.validate(req,resp,"lastname",lastname);
        this.validate(req,resp,"email",email);
        if(!password.equals(passwordConfirm)){
            this.redirectToRegisterPageWithError(req,resp,"password");
        }

        int rowsAffected = this.userService.registerNewUser(firstname, lastname, email, password);
        if (rowsAffected < 1) {
            this.redirectToRegisterPageWithError(req, resp, "InternalError");
        } else {
            this.authAndRedirectToHomePage(req, resp, email, password);
        }
    }

    private void validate(HttpServletRequest req, HttpServletResponse resp,String field, String value) throws ServletException, IOException {
        if(value == null) {
            this.redirectToRegisterPageWithError(req,resp,field);
        }
    }

    private void authAndRedirectToHomePage(HttpServletRequest req, HttpServletResponse resp, String email, String password) throws IOException {
        Optional<User> user = this.userService.fetchUser(email, password);
        HttpSession session = req.getSession();
        session.setAttribute("user", user.get());
        resp.sendRedirect(req.getContextPath()+"/");
    }

    private void redirectToRegisterPageWithError(HttpServletRequest req, HttpServletResponse resp, String field) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("register.jsp");
        req.setAttribute(field, "Not valid");
        view.forward(req, resp);
    }
}
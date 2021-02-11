package com.online_shop.online_shop;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/login-handler")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String name = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        if (name.equals("admin") && password.equals("123")) {
            session.setAttribute("session", "logged");
            String path = "/index.jsp";
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(req, resp);
        }
        else {
            RequestDispatcher view = req.getRequestDispatcher("login.html");
            view.forward(req, resp);
        }
    }
}
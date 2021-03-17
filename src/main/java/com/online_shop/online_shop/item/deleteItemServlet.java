package com.online_shop.online_shop.item;

import javaBean.User;
import services.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "deleteItemServlet", value = "/item/deleteItem")
public class deleteItemServlet extends HttpServlet {

    private final ItemService itemService;

    public deleteItemServlet() {
        this.itemService = new ItemService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User)req.getSession().getAttribute("user");
        if(currentUser == null || !currentUser.isAdmin()) {
            resp.sendRedirect("../403.jsp");
            return;
        }

        PrintWriter writer = resp.getWriter();

        Long targetId = Long.parseLong(req.getParameter("targetId"));

        if (!itemService.deleteItemViaHibernate(targetId)) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
        }

        resp.sendRedirect(req.getContextPath() + "/item/itemManagement");
    }
}
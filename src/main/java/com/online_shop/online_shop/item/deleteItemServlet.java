package com.online_shop.online_shop.item;

import javaBean.Item;
import services.ItemService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "deleteItemServlet", value = "/item/deleteItem")
public class deleteItemServlet extends HttpServlet {

    private final ItemService itemService;

    public deleteItemServlet() {
        this.itemService = new ItemService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        try {
            int targetId = Integer.parseInt(req.getParameter("targetId"));
            itemService.delete(targetId, writer);
            resp.sendRedirect(req.getContextPath() + "/item/itemManagement");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("notfound.jsp").forward(req, resp);
        }
    }
}
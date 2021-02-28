package com.online_shop.online_shop;

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

@WebServlet(name = "itemManagementServlet", value = "/item/itemManagement")
public class ItemManagementServlet extends HttpServlet {

    private final ItemService itemService;

    public ItemManagementServlet() {
        this.itemService = new ItemService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        ArrayList<Item> result = itemService.select(writer);

        writer.println(result.size());
        req.setAttribute("items", result);
        req.setAttribute("size", result.size());
        RequestDispatcher view = req.getRequestDispatcher("itemManagement.jsp");
        view.forward(req, resp);
    }
}
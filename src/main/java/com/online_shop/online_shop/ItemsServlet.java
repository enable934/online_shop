package com.online_shop.online_shop;

import javaBean.Item;
import services.ItemService;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "indexServlet", value = "/")
public class ItemsServlet extends HttpServlet {

    private final ItemService itemService;

    public ItemsServlet() {
        this.itemService = new ItemService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        ArrayList<Item> result = itemService.select(writer);

        writer.println(result.size());
        req.setAttribute("items", result);
        req.setAttribute("size", result.size());
        RequestDispatcher view = req.getRequestDispatcher("index.jsp");
        view.forward(req, resp);
    }
}
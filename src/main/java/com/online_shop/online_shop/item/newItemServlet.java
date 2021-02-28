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

@WebServlet(name = "newItemServlet", value = "/item/newItem")
public class newItemServlet extends HttpServlet {

    private final ItemService itemService;

    public newItemServlet() {
        this.itemService = new ItemService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/item/newItem.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String itemName = req.getParameter("itemName");
        String itemDescription = req.getParameter("itemDescription");
        float itemPrice = Float.parseFloat(req.getParameter("itemPrice"));
        this.validate(req,resp,"itemName", itemName);
        this.validate(req,resp,"itemDescription", itemDescription);
        this.validate(req,resp,"itemPrice", itemPrice);

        Item newItem = new Item(itemName, itemDescription, itemPrice);
        int rowsAffected = itemService.addItem(newItem, writer);
        if (rowsAffected < 1) {
            this.redirectToNewItemPageWithError(req, resp, "InternalError");
        }

        req.setAttribute("isSaved", true);
        RequestDispatcher view = req.getRequestDispatcher("newItem.jsp");
        view.forward(req, resp);
    }

    private void validate(HttpServletRequest req, HttpServletResponse resp,String field, String value) throws ServletException, IOException {
        if(value == null) {
            this.redirectToNewItemPageWithError(req,resp,field);
        }
    }

    private void validate(HttpServletRequest req, HttpServletResponse resp,String field, float value) throws ServletException, IOException {
        if(value <= 0) {
            this.redirectToNewItemPageWithError(req,resp,field);
        }
    }

    private void redirectToNewItemPageWithError(HttpServletRequest req, HttpServletResponse resp, String field) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("/item/newItem.jsp");
        req.setAttribute(field, "Not valid");
        view.forward(req, resp);
    }
}
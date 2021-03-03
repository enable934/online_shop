package com.online_shop.online_shop.item;

import DTOs.ReviewDTO;
import javaBean.Item;
import javaBean.User;
import services.ItemService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "editItemServlet", value = "/item/editItem")
public class edtItemServlet extends HttpServlet {

    private final ItemService itemService;
    private Item targetItem;
    private final String nameKey = "editItemItemName";
    private final String desKey = "editItemItemDescription";
    private final String priceKey = "editItemItemPrice";
    private final String sameObjectsKey = "editItemSameObjects";
    private final String savedKey = "editItemIsSaved";
    private final String errorKey = "InternalError";

    public edtItemServlet() {
        this.itemService = new ItemService();
        targetItem = null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String value = (String)session.getAttribute(priceKey);
        User currentUser = (User)session.getAttribute("user");
        if(currentUser == null || !currentUser.isAdmin()) {
            resp.sendRedirect("../403.jsp");
            return;
        }

        RequestDispatcher view = req.getRequestDispatcher("/item/editItem.jsp");

        int itemId = Integer.parseInt(req.getParameter("id"));
        PrintWriter writer = resp.getWriter();

        targetItem = itemService.selectById(itemId, writer);

        if (targetItem == null) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
        }

        req.setAttribute("item", targetItem);
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User currentUser = (User)session.getAttribute("user");

        if(currentUser == null || !currentUser.isAdmin()) {
            resp.sendRedirect("../403.jsp");
            return;
        } else if (targetItem == null) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
            return;
        }

        PrintWriter writer = resp.getWriter();

        String itemName = req.getParameter(nameKey);
        String itemDescription = req.getParameter(desKey);
        float itemPrice = Float.parseFloat(req.getParameter(priceKey));

        clearSession(session);
        if (!this.validate(req,resp,nameKey, itemName)
                || !this.validate(req,resp,desKey, itemDescription)
                || !this.validate(req,resp,priceKey, itemPrice)) {
            return;
        }

        Item newItem = new Item(targetItem.getId(), itemName, itemDescription, itemPrice);
        if (targetItem.equals(newItem)) {
            this.redirectToEditItemPageWithError(req, resp, sameObjectsKey);
            return;
        }

        int rowsAffected = itemService.update(newItem, writer);
        if (rowsAffected < 1) {
            this.redirectToEditItemPageWithError(req, resp, errorKey);
            return;
        }

        session.setAttribute(savedKey, true);
        resp.sendRedirect(req.getContextPath() + "/item/editItem?id=" + targetItem.getId());
    }

    private void clearSession(HttpSession session) {
        session.removeAttribute(nameKey);
        session.removeAttribute(desKey);
        session.removeAttribute(priceKey);
        session.removeAttribute(sameObjectsKey);
        session.removeAttribute(savedKey);
        session.removeAttribute(errorKey);
    }

    private boolean validate(HttpServletRequest req, HttpServletResponse resp,String field, String value) throws ServletException, IOException {
        if(value == null) {
            this.redirectToEditItemPageWithError(req,resp,field);
            return false;
        }

        return true;
    }

    private boolean validate(HttpServletRequest req, HttpServletResponse resp,String field, float value) throws ServletException, IOException {
        if(value <= 0) {
            this.redirectToEditItemPageWithError(req,resp,field);
            return false;
        }

        return true;
    }

    private void redirectToEditItemPageWithError(HttpServletRequest req, HttpServletResponse resp, String field) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute(field, "Not valid");
        resp.sendRedirect(req.getContextPath() + "/item/editItem?id=" + targetItem.getId());
    }
}
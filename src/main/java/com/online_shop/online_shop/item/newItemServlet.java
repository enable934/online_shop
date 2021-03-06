package com.online_shop.online_shop.item;

import javaBean.Item;
import javaBean.User;
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
    private final String nameKey = "itemName";
    private final String desKey = "itemDescription";
    private final String priceKey = "itemPrice";

    public newItemServlet() {
        this.itemService = new ItemService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User)req.getSession().getAttribute("user");
        if(currentUser == null || !currentUser.isAdmin()) {
            resp.sendRedirect("../403.jsp");
            return;
        }
        getServletContext().getRequestDispatcher("/item/newItem.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User)req.getSession().getAttribute("user");
        if(currentUser == null || !currentUser.isAdmin()){
            resp.sendRedirect("../403.jsp");
            return;
        }

        PrintWriter writer = resp.getWriter();

        String itemName = req.getParameter(nameKey);
        String itemDescription = req.getParameter(desKey);
        float itemPrice = Float.parseFloat(req.getParameter(priceKey));
        if (!this.validate(req, resp, nameKey, itemName)
                || !this.validate(req, resp, desKey, itemDescription)
                || !this.validate(req, resp, priceKey, itemPrice)) {
            return;
        }

        Long result = itemService.addItemViaHibernate(itemName, itemDescription, itemPrice);
        if (result == -1L) {
            this.redirectToNewItemPageWithError(req, resp, "InternalError");
        }

        req.setAttribute("isSaved", true);
        RequestDispatcher view = req.getRequestDispatcher("newItem.jsp");
        view.forward(req, resp);
    }

    private boolean validate(HttpServletRequest req, HttpServletResponse resp,String field, String value) throws ServletException, IOException {
        if(value == null) {
            this.redirectToNewItemPageWithError(req,resp,field);
            return false;
        }

        return true;
    }

    private boolean validate(HttpServletRequest req, HttpServletResponse resp,String field, float value) throws ServletException, IOException {
        if(value <= 0) {
            this.redirectToNewItemPageWithError(req,resp,field);
            return false;
        }

        return true;
    }

    private void redirectToNewItemPageWithError(HttpServletRequest req, HttpServletResponse resp, String field) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("/item/newItem.jsp");
        req.setAttribute(field, "Not valid");
        view.forward(req, resp);
    }
}
package com.online_shop.online_shop;

import hibernate.dao.ItemEntity;
import hibernate.utils.HibernateSessionFactory;
import javaBean.Item;
import org.hibernate.Session;
import services.ItemService;

import java.io.*;
import java.sql.Timestamp;
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

        /*Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        ItemEntity itemEntity = new ItemEntity();

        itemEntity.setName("TESTHIB1");
        itemEntity.setDescription("TESTHIB1");
        itemEntity.setPrice(100);

        session.save(itemEntity);
        session.getTransaction().commit();

        session.close();*/

        ArrayList<Item> result = itemService.select(writer);

        writer.println(result.size());
        req.setAttribute("items", result);
        req.setAttribute("size", result.size());
        RequestDispatcher view = req.getRequestDispatcher("index.jsp");
        view.forward(req, resp);
    }
}
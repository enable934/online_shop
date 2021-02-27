package com.online_shop.online_shop;

import javaBean.Item;
import services.DBManager;

import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/item")
public class ItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager manager = new DBManager();
        PrintWriter writer = resp.getWriter();

        ArrayList<Item> result = new ArrayList<Item>();
        try{
            ResultSet items = manager.select("SELECT id, name, description, price FROM item");
            if(items == null)
                writer.println("items == null");
            while(items.next()){
                Item temp = new Item(items.getInt(1),
                    items.getString(2),
                    items.getString(3),
                    items.getInt(4));
                result.add(temp);
            }
        }
        catch(Exception e){
            writer.println(e);
            writer.println(e.getMessage());
            writer.println(e.getCause());
        }
        writer.println(result.size());
        req.setAttribute("items", result);
        req.setAttribute("size", result.size());
        RequestDispatcher view = req.getRequestDispatcher("items.jsp");
        view.forward(req, resp);
    }
}
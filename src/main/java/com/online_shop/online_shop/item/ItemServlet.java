package com.online_shop.online_shop.item;

import DTOs.ReviewDTO;
import hibernate.entity.ItemEntity;
import javaBean.Item;
import services.ItemService;
import services.ReviewService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "itemServlet", value = "/item")
public class ItemServlet extends HttpServlet {

    private final ItemService itemService;
    private final ReviewService reviewService;
    private Long itemId;
    private int reviewScore;

    public ItemServlet() {
        this.itemService = new ItemService();
        this.reviewService = new ReviewService();
        itemId = -1L;
        reviewScore = -1;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("item/item.jsp");

        itemId = Long.parseLong(req.getParameter("id"));
        reviewScore = -1;
        PrintWriter writer = resp.getWriter();

        ItemEntity targetItem = itemService.getViaHibernate(itemId);
        ArrayList<ReviewDTO> reviewForCurrentItem = reviewService.selectForItem(itemId, writer);

        if (reviewForCurrentItem.size() > 0) {
            reviewScore = 0;

            for (ReviewDTO review : reviewForCurrentItem) {
                reviewScore += review.getRate_score();
            }

            reviewScore = Math.round(reviewScore / reviewForCurrentItem.size());
        }

        req.setAttribute("reviews", reviewForCurrentItem);
        req.setAttribute("item", targetItem);
        req.setAttribute("reviewScore", reviewScore);
        view.forward(req, resp);
    }

    // reserved for add review
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
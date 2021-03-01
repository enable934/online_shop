package com.online_shop.online_shop;
import DTOs.ItemInBasketDTO;
import javaBean.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import DTOs.UserBasketDTO;
import services.Helpers;
import services.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

@WebServlet("/userBasketServlet/*")
public class UserBasketServlet extends HttpServlet {

    private final UserService userService;
    private int userId;

    public UserBasketServlet() {
        this.userService = new UserService();
        userId = -1;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JSONObject json=new JSONObject();
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        if(user != null) {
            userId = user.getId();
            UserBasketDTO basket = userService.getUserBasketInfo(userId);

            json.put("totalCount", basket.getTotalCount());
            json.put("totalPrice", basket.getTotalPrice());

            try{
                JSONArray jItemsArr = new JSONArray();
                for(ItemInBasketDTO item : basket.getItems()){
                    JSONObject jItem = new JSONObject();
                    jItem.put("itemId", item.getItemId());
                    jItem.put("itemName", item.getItemName());
                    jItem.put("itemsCount", item.getItemsCount());
                    jItem.put("totalPrice", item.getTotalPrice());

                    jItemsArr.add(jItem);
                }

                json.put("items", jItemsArr);
            }
            catch(Exception e){
                json.put("error", e.getMessage());
            }
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json.toJSONString());
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try{
            String body = inputStreamToString(req.getInputStream());
            Map<String, String> params =  Helpers.splitQuery(body);
            int itemId = Integer.parseInt(params.get("itemId"));
            boolean isAdd = Boolean.parseBoolean(params.get("isAdd"));

            HttpSession session = req.getSession();
            User user = (User)session.getAttribute("user");
            if(user != null) {
                userId = user.getId();
                userService.putDataToBasket(userId, itemId, isAdd);
            }
        }
        catch(Exception e){
            System.out.println("doPut Exception: " + e.getMessage() );
        }
    }

    private static String inputStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        return scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
    }
}

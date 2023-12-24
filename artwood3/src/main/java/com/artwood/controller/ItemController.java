package com.artwood.controller;




import com.artwood.Dao.ItemDaoImp;
import com.artwood.model.Item;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ItemController", urlPatterns = {"/ItemController"})
public class ItemController extends HttpServlet {

    private ItemDaoImp articleDao = new ItemDaoImp();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Item item = new Item();
        item.setName(nom);
        item.setPrice(price);
        item.setQuantity(quantity);

        articleDao.addItem(item); // Assuming this method is implemented in ArticleDao


    }}
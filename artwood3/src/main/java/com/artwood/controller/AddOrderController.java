package com.artwood.controller;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import com.artwood.Dao.ItemDao;
import com.artwood.Dao.OrderDao;
import com.artwood.model.Client;
import com.artwood.model.Item;
import com.artwood.model.Order;

import com.artwood.Dao.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 * Servlet implementation class Logincontroler
 */

public class AddOrderController extends HttpServlet {


    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String[] articles = request.getParameterValues("item");
        String[] quantites = request.getParameterValues("quantity");
        String email = request.getParameter("email");

        System.out.println("Item: " + Arrays.toString(articles));
        System.out.println("Quantity: " + Arrays.toString(quantites));
        Client client =  ClientDaoImp.searchByEmail(email) ;

        assert client != null;
        Order order = new Order((int) client.getId(), LocalDate.now(),"confirmed");
        ArrayList<Item> listeArticles = new ArrayList<>();
        int[] listequontite = new int[15];
        for (int i = 0; i < articles.length; i++) {
            listeArticles.add(ItemDaoImp.searchItemByName(articles[i]));
            listequontite[i]=paresInt(quantites[i]);
        }
        order.setItems(listeArticles);
        OrderDaoImp.addOrder(order);
        OrderDaoImp.addDBO(listeArticles,order.getId(),listequontite);
        response.sendRedirect("addorder.jsp");
    }

    private int paresInt(String string) {
        // TODO Auto-generated method stub
        return 0;
    }

}
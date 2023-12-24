package com.artwood.controller;


import com.artwood.Dao.ClientDao;
import com.artwood.Dao.ClientDaoImp;
import com.artwood.model.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ClientController", urlPatterns = {"/ClientController"})
public class ClientController extends HttpServlet {

    private ClientDao clientDao = new ClientDaoImp();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nom");
        String email = request.getParameter("email");

        Client client = new Client();
        client.setName(name);
        client.setEmail(email);

        clientDao.addClient(client); // Assuming this method is implemented in ClientDao

        // Redirect or forward to a confirmation page or back to the client form
        response.sendRedirect("AddClient.jsp"); // Modify as needed
    }
}


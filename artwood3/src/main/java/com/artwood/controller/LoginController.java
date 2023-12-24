package com.artwood.controller;

import com.artwood.Dao.UserDao;
import com.artwood.Dao.UserDaoImp;
import com.artwood.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private UserDao userDao = new UserDaoImp();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");

        User user = UserDaoImp.login(email,password); // Assuming this method is implemented in UserDao

        if (user != null && user.getPassword().equals(password)) { // Simple check, consider stronger validation
            // Login success
            HttpSession session = request.getSession();
            session.setAttribute("user", user); // Storing user in session
            response.sendRedirect("dashboard.jsp"); // Redirect to dashboard
        } else {
            // Login failure
            request.setAttribute("ERROR", "Invalid email or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}

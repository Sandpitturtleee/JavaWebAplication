package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@WebServlet(name = "DisplayUsersServlet", value = "/DisplayUsersServlet")
public class DisplayUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetUsers users = new GetUsers();
        List<User> list = users.getAllUsers();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users.jsp");
        request.setAttribute("list", list);
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@WebServlet(name = "DisplayUserAccountsServlet", value = "/DisplayUserAccountsServlet")
public class DisplayUserAccountsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetUserAccounts userAccounts = new GetUserAccounts();
        String userLogin = request.getParameter("login");
        List<UserAccounts> list = userAccounts.getAllUserAccounts(userLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/passwordManager.jsp");
        request.setAttribute("list", list);
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

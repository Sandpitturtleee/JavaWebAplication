package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteUserAccountServlet", value = "/DeleteUserAccountServlet")
public class DeleteUserAccountServlet extends HttpServlet {
    String message ="";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userLogin =(String)session.getAttribute("login");
        UserAccounts userAccount = new UserAccounts();
        userAccount.deleteAccount(userLogin,"Login");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        message = "Account deleted";
        request.setAttribute("message", message);
        dispatcher.forward(request,response);
    }
}

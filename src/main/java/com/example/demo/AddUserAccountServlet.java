package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddUserAccountServlet", value = "/AddUserAccountServlet")
public class AddUserAccountServlet extends HttpServlet {
    String message = "";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userLogin =(String)session.getAttribute("login");
        String type = request.getParameter("type");
        String url = request.getParameter("url");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserAccounts userAccount = new UserAccounts();
        userAccount.setType(type);
        userAccount.setUrl(url);
        userAccount.setLogin(login);
        userAccount.setEmail(email);
        userAccount.setPassword(password);
        if(userAccount.addAccount(userLogin)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/DisplayUserAccountsServlet");
            message = "New account added";
            request.setAttribute("message", message);
            dispatcher.forward(request,response);
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/DisplayUserAccountsServlet");
            message = "Error";
            request.setAttribute("message", message);
            dispatcher.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

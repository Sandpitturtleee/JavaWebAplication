package com.example.demo;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    String result = "";
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        if(user.login()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/users.jsp");
            result = "Logged in" + login;
            request.setAttribute("result", result);
            dispatcher.forward(request,response);
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/wronglogin.jsp");
            result = "Wrong login or password";
            request.setAttribute("result", result);
            dispatcher.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {


    }

    public void destroy() {
    }
}


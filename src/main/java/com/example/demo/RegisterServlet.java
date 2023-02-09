package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    String message = "";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validateRegisterForm(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void validateRegisterForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password_confirm = request.getParameter("password_confirm");

        if (!password.equals(password_confirm)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
            message = "Please confirm password";
            request.setAttribute("message", message);
            dispatcher.forward(request,response);
        } else {
            registerNewUser(request,response);
        }

    }
    protected void registerNewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);
        if(user.register()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            message = "User registered" + login + email + password;
            request.setAttribute("message", message);
            dispatcher.forward(request,response);
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
            message = "User already exists";
            request.setAttribute("message", message);
            dispatcher.forward(request,response);
        }
    }
}

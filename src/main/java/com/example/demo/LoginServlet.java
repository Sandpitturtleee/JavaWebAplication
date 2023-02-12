package com.example.demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    String message = "";
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        if(user.login()) {
            session.setAttribute("login", user.getLogin());
            if(user.getLogin().equals("Admin"))
            {
                ServletContext context= getServletContext();
                RequestDispatcher rd= context.getRequestDispatcher("/DisplayUsersServlet");
                rd.forward(request, response);

            }else {
                ServletContext context= getServletContext();
                RequestDispatcher rd= context.getRequestDispatcher("/DisplayUserAccountsServlet");
                rd.forward(request, response);
            }
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            message = "Wrong login or password";
            request.setAttribute("message", message);
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


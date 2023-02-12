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
        HttpSession session = request.getSession();
        if (!isEmpty(request.getParameter("login")))
        {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            session.setAttribute("login", login);
            session.setAttribute("password", password);
        }
        String sessionLogin = (String) session.getAttribute("login");
        String sessionPassword = (String) session.getAttribute("password");
        User user = new User();
        user.setLogin(sessionLogin);
        user.setPassword(sessionPassword);
        if(user.login()) {
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
    public static boolean isEmpty(String string) {
        return (string == null || string.isEmpty());
    }
}


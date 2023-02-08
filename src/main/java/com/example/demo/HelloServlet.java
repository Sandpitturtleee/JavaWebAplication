package com.example.demo;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    User user = new User();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        PrintWriter out = response.getWriter();

        if(user.login()) {
            response.sendRedirect(request.getContextPath() + "/users.jsp");
            out.println("Ok");
        }else {
            response.sendRedirect(request.getContextPath() + "/wronglogin.jsp");
            out.println("No");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
    public void destroy() {
    }
}
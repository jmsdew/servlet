package com.ohgiraffers.section03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request")
public class RequestListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("username", "hong");
        req.setAttribute("age", 10);
        req.setAttribute("gender" , "m");

        req.setAttribute("username", "honghong");

        req.removeAttribute("username");

    }
}

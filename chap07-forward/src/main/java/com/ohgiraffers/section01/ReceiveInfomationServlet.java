package com.ohgiraffers.section01;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward")
public class ReceiveInfomationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

   //     req.setCharacterEncoding("UTF-8");  -- 이제 생략 가능

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        System.out.println("user Id : " + userId);
        System.out.println("password : " + password);

        req.setAttribute("userId" , userId);
        RequestDispatcher rd = req.getRequestDispatcher("print");           // 전파 -- print 쪽에서 처리하게 보냄
        rd.forward(req,resp);                                                    // 여기서 객체를 담아 전달


    }
}

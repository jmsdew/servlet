package com.ohgiraffers.section02;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        System.out.println("userId : " + userId);
        System.out.println("password : " + password);
        System.out.println("name : " + name);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();           // 암호화
        System.out.println("비밀번호가 pass01 인지 확인 : " + passwordEncoder.matches("pass01", password));
        System.out.println("비밀번호가 pass02 인지 확인 : " + passwordEncoder.matches("pass02", password));


    }
}

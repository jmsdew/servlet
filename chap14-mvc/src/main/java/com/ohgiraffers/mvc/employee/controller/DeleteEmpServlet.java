package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.dto.EmpDTO;
import com.ohgiraffers.mvc.employee.dto.EmpDeleteDTO;
import com.ohgiraffers.mvc.employee.dto.EmpUpdateDTO;
import com.ohgiraffers.mvc.employee.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employeesd")
public class DeleteEmpServlet extends HttpServlet {

    private EmpService empService;

    @Override    // init은 리소스를 할당하는 경우 사용한다.
    public void init() throws ServletException {
        empService = new EmpService();
        System.out.println(empService + " 현재 상태");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId = request.getParameter("empId");




        String path = null;


        if(empId == null){
            // 전체 조회
            // get /employees
            List<EmpDTO> emplist = empService.selectAllEmp();

            request.setAttribute("emplist", emplist);
            path = "/WEB-INF/views/employee/empList.jsp";
        }else {
            // get / employees?empId=200
            // 단일 사원 조회
            Object result = empService.selectEmp(empId);

            if(result instanceof EmpDTO){
                result = (EmpDTO)result;
            }else {
                result = (String)result;
            }
            request.setAttribute("emp", result);
            path ="/WEB-INF/views/employee/showEmpInfo.jsp";

        }
        request.getRequestDispatcher(path).forward(request,response);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        EmpDeleteDTO delete = new EmpDeleteDTO();
        delete.setEmpId(req.getParameter("empId"));


        int result = empService.delete(delete);

        String path;
        if(result > 0){
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("message", "퇴사 처리 성공");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "퇴사 처리 실패");
        }
        req.getRequestDispatcher(path).forward(req,resp);

    }

    @Override
    public void destroy() {
        empService = null;
        System.out.println(empService + " 현재 상태");

    }

}

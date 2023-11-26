package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.dto.EmpDTO;
import com.ohgiraffers.mvc.employee.dto.EmpInsertDTO;
import com.ohgiraffers.mvc.employee.dto.EmpUpdateDTO;
import com.ohgiraffers.mvc.employee.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/employeesz")
public class UpdateEmpServlet extends HttpServlet {

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
        EmpUpdateDTO update = new EmpUpdateDTO();
        update.setEmpId(req.getParameter("empId"));
        update.setEmpNo(req.getParameter("empNo"));
        update.setEmpName(req.getParameter("empName"));
        update.setEmail(req.getParameter("email"));
        update.setPhone(req.getParameter("phone"));
        update.setDeptCode(req.getParameter("deptCode"));
        update.setJobCode(req.getParameter("jobCode"));
        update.setSalLevel(req.getParameter("salLevel"));
        update.setSalary(Integer.parseInt(req.getParameter("salary")));
        update.setBonus(Double.parseDouble(req.getParameter("bonus")));
        update.setManagerId(req.getParameter("managerId"));
        update.setHireDate(java.sql.Date.valueOf(req.getParameter("hireDate")));

        int result = empService.update(update);

        String path;
        if(result > 0){
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("message", "업데이트 성공");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "업데이트 실패");
        }
        req.getRequestDispatcher(path).forward(req,resp);

    }

    @Override
    public void destroy() {
        empService = null;
        System.out.println(empService + " 현재 상태");

    }
}

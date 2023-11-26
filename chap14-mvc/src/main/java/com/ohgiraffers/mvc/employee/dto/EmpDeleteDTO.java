package com.ohgiraffers.mvc.employee.dto;

public class EmpDeleteDTO {
    private String empId;

    public EmpDeleteDTO() {
    }

    public EmpDeleteDTO(String empId) {
        this.empId = empId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "EmpDeleteDTO{" +
                "empId='" + empId + '\'' +
                '}';
    }
}

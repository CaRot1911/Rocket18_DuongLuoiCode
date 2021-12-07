package com.vti.dto;

public class DepartmentDTO {

    private String departmentName;

    private short totalMember;

    public DepartmentDTO(String departmentName, short totalMember) {
        this.departmentName = departmentName;
        this.totalMember = totalMember;
    }

    public DepartmentDTO() {
    }

    public short getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(short totalMember) {
        this.totalMember = totalMember;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

package com.example.onetoonemappingcrudoperationexample.models;

import com.example.onetoonemappingcrudoperationexample.entities.LaptopEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;

public class EmployeeModel {
    private Long employeeId;
    private String name;
    private String designation;
    private String department;
    private String company;
    private LaptopModel laptop;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LaptopModel getLaptop() {
        return laptop;
    }

    public void setLaptop(LaptopModel laptop) {
        this.laptop = laptop;
    }
}

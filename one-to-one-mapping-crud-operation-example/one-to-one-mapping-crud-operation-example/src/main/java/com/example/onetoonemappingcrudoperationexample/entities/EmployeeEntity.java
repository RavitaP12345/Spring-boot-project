package com.example.onetoonemappingcrudoperationexample.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_details")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long employeeId;
    private String name;
    private String designation;
    private String department;
    private String company;
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private LaptopEntity laptop;

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

    public LaptopEntity getLaptop() {
        return laptop;
    }

    public void setLaptop(LaptopEntity laptop) {
        this.laptop = laptop;
    }

}

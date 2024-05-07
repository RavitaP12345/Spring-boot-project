package com.example.onetoonemappingcrudoperationexample.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "laptop_details")
public class LaptopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long laptopId;
    private String name;
    private String brand;
    private String model;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    public Long getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(Long laptopId) {
        this.laptopId = laptopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
}

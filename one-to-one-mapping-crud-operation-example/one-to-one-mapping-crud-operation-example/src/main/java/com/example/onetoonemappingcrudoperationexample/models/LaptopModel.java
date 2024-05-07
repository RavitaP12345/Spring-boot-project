package com.example.onetoonemappingcrudoperationexample.models;

import com.example.onetoonemappingcrudoperationexample.entities.EmployeeEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class LaptopModel {
    private Long laptopId;
    private String name;
    private String brand;
    private String model;

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
}

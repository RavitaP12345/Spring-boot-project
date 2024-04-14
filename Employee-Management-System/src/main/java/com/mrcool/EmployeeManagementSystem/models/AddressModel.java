package com.mrcool.EmployeeManagementSystem.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddressModel {
    private Long id;
    @NotNull(message = "Address type must not be null.")
    @NotBlank(message = "Address type must not be blank.")
    private String addressType;
    @NotNull(message = "City must not be null.")
    @NotBlank(message = "City must not be blank.")
    private String city;
    @NotNull(message = "State must not be null.")
    @NotBlank(message = "State must not be null.")
    private String state;
    @NotNull(message = "Address must not be null.")
    @NotBlank(message = "Address must not be blank.")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

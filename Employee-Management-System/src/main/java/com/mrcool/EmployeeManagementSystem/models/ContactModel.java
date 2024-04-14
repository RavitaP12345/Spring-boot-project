package com.mrcool.EmployeeManagementSystem.models;

import jakarta.validation.constraints.*;

public class ContactModel {
    private Long id;
    @NotNull(message = "Contact number must not be null.")
    @NotBlank(message = "Contact number must not be blank.")
    @Size(min = 10, max = 10, message = "Contact number must be 10 digits.")
    @Pattern(regexp="^[0-9]*$", message="Contact number must contain only digits")
    private String contactNumber;
    @NotNull(message = "Contact Type must not be null.")
    @NotBlank(message = "Contact Type must not be blank.")
    private String contactType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }
}

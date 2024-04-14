package com.mrcool.EmployeeManagementSystem.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EmailModel {
    private Long id;
    @NotNull(message = "Email type must not be null.")
    @NotBlank(message = "Email type must not be blank.")
    private String emailType;
    @NotNull(message = "Email address must not be null.")
    @NotBlank(message = "Email address must not be blank.")
    @Email(message = "Email address is not in good format.")
    private String emailAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}

package com.mrcool.EmployeeManagementSystem.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CollegeModel {
    private Long id;
    @NotNull(message = "College name must not be null.")
    @NotBlank(message = "College name must not be blank.")
    private String collegeName;
    @NotNull(message = "College address must not be null.")
    @NotBlank(message = "College address must not be blank.")
    private String collegeAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeAddress() {
        return collegeAddress;
    }

    public void setCollegeAddress(String collegeAddress) {
        this.collegeAddress = collegeAddress;
    }
}

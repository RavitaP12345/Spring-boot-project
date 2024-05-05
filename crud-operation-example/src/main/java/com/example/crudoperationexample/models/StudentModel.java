package com.example.crudoperationexample.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StudentModel {
    private Long id;
    @NotNull(message = "Student name must not be null.")
    @NotBlank(message = "Student name must not be blank.")
    @Size(min = 5, max = 50, message = "Student name must be in between 5 character to 50 character.")
    private String studentName;
    @NotNull(message = "Student email must not be null.")
    @NotBlank(message = "Student email must not be blank.")
    @Email(message = "Student email is incorrect.")
    private String studentEmail;
    @NotNull(message = "Student mobile number must not be null.")
    @NotBlank(message = "Student mobile number must not be blank.")
    @Size(min = 10, max = 10, message = "Mobile number must be of 10 digits.")
    private String studentMobile;
    @NotNull(message = "Address must not be null.")
    @NotBlank(message = "Address must not be blank.")
    private String studentAddress;
    @NotNull(message = "City must not be null.")
    @NotBlank(message = "City must not be blank.")
    private String studentCity;
    @NotNull(message = "State must not be null.")
    @NotBlank(message = "State must not be blank.")
    private String studentState;
    @NotNull(message = "Country must not be null.")
    @NotBlank(message = "Country must not be blank.")
    private String studentCountry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    public String getStudentState() {
        return studentState;
    }

    public void setStudentState(String studentState) {
        this.studentState = studentState;
    }

    public String getStudentCountry() {
        return studentCountry;
    }

    public void setStudentCountry(String studentCountry) {
        this.studentCountry = studentCountry;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentMobile='" + studentMobile + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentCity='" + studentCity + '\'' +
                ", studentState='" + studentState + '\'' +
                ", studentCountry='" + studentCountry + '\'' +
                '}';
    }
}

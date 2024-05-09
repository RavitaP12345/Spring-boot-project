package com.example.EmailNotification.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StudentModel {
    private Long studentId;
    @NotNull(message = "Student's name must not be null.")
    @NotBlank(message = "Student's name must not be blank.")
    @Size(min = 4, max = 50, message = "Student's name must be in between 4 to 50 characters.")
    private String studentName;
    @NotNull(message = "Mobile number must not be null.")
    @NotBlank(message = "Mobile number must not be blank.")
    @Size(min = 10, max = 10, message = "Mobile number must be of 10 digits.")
    private String studentMobile;
    @NotNull(message = "Email id must not be null.")
    @NotBlank(message = "Email id must not be blank.")
    @Email(message = "Email id is incorrect. Please enter the valid email id.")
    private String studentEmail;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentMobile='" + studentMobile + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                '}';
    }
}

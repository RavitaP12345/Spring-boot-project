package com.example.microservice1.models;


public class StudentModel {
    private Long studentId;
    private String studentName;
    private String studentEmail;
    private String studentMobile;
    private CollegeModel college;

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

    public CollegeModel getCollege() {
        return college;
    }

    public void setCollege(CollegeModel college) {
        this.college = college;
    }
}

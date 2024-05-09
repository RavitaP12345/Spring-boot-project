package com.example.EmailNotification.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "student_details")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long studentId;
    private String studentName;
    private String studentMobile;
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
        return "StudentEntity{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentMobile='" + studentMobile + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                '}';
    }
}

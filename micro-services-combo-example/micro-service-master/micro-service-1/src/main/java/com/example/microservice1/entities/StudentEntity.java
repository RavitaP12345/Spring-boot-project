package com.example.microservice1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "student_details")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long studentId;
    private String studentName;
    private String studentEmail;
    private String studentMobile;
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private CollegeEntity college;

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

    public CollegeEntity getCollege() {
        return college;
    }

    public void setCollege(CollegeEntity college) {
        this.college = college;
    }
}

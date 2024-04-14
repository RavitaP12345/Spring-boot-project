package com.mrcool.EmployeeManagementSystem.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "email_details")
public class EmailEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private Long id;
    private String emailType;
    private String emailAddress;
    @ManyToOne()
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

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

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}

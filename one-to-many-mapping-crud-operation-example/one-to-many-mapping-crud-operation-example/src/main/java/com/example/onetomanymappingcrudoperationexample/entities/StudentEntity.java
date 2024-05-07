package com.example.onetomanymappingcrudoperationexample.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "student_details")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long studentId;
    private String studentName;
    private String studentEmail;
    private String studentMobileNumber;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<BookEntity> books;

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

    public String getStudentMobileNumber() {
        return studentMobileNumber;
    }

    public void setStudentMobileNumber(String studentMobileNumber) {
        this.studentMobileNumber = studentMobileNumber;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
}

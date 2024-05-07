package com.example.onetomanymappingcrudoperationexample.models;

import com.example.onetomanymappingcrudoperationexample.entities.BookEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class StudentModel {
    private Long studentId;
    private String studentName;
    private String studentEmail;
    private String studentMobileNumber;
    private List<BookModel> books;

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

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
}

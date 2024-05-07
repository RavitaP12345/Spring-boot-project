package com.example.onetomanymappingcrudoperationexample.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "book_details")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bookId;
    private String bookName;
    private String author;
    private String bookType;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}

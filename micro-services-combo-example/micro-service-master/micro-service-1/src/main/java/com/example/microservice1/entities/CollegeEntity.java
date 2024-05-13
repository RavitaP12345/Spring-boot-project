package com.example.microservice1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "college_details")
public class CollegeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long collegeId;
    private String collegeName;
    private String collegeLocation;
    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeLocation() {
        return collegeLocation;
    }

    public void setCollegeLocation(String collegeLocation) {
        this.collegeLocation = collegeLocation;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}

package com.mrcool.EmployeeManagementSystem.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student_details")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String salutation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<EmailEntity> emailEntities;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<ContactEntity> contactEntities;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<AddressEntity> addressEntities;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "student")
    private CollegeEntity college;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public List<EmailEntity> getEmailEntities() {
        return emailEntities;
    }

    public void setEmailEntities(List<EmailEntity> emailEntities) {
        this.emailEntities = emailEntities;
    }

    public List<ContactEntity> getContactEntities() {
        return contactEntities;
    }

    public void setContactEntities(List<ContactEntity> contactEntities) {
        this.contactEntities = contactEntities;
    }

    public List<AddressEntity> getAddressEntities() {
        return addressEntities;
    }

    public void setAddressEntities(List<AddressEntity> addressEntities) {
        this.addressEntities = addressEntities;
    }

    public CollegeEntity getCollege() {
        return college;
    }

    public void setCollege(CollegeEntity college) {
        this.college = college;
    }

}

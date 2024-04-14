package com.mrcool.EmployeeManagementSystem.models;

import com.mrcool.EmployeeManagementSystem.entities.AddressEntity;
import com.mrcool.EmployeeManagementSystem.entities.CollegeEntity;
import com.mrcool.EmployeeManagementSystem.entities.ContactEntity;
import com.mrcool.EmployeeManagementSystem.entities.EmailEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class StudentModel {
    private Long id;
    @NotNull(message = "First name must not be null.")
    @NotBlank(message = "First name must not be blank.")
    @Size(min = 2, max = 50, message = "First name should be in 2 to 50 character.")
    private String firstName;
    @NotNull(message = "Last name must not be null.")
    @NotBlank(message = "Last name must not be blank.")
    @Size(min = 2, max = 50, message = "Last name should be in 2 to 50 character.")
    private String lastName;
    @NotNull(message = "Salutation must not be null.")
    @NotBlank(message = "Salutation must not be blank.")
    private String salutation;
    private List<EmailModel> emails;
    private List<ContactModel> contacts;
    private List<AddressModel> addresses;
    private CollegeModel college;

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

    public List<EmailModel> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailModel> emails) {
        this.emails = emails;
    }

    public List<ContactModel> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactModel> contacts) {
        this.contacts = contacts;
    }

    public List<AddressModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressModel> addresses) {
        this.addresses = addresses;
    }

    public CollegeModel getCollege() {
        return college;
    }

    public void setCollege(CollegeModel college) {
        this.college = college;
    }
}

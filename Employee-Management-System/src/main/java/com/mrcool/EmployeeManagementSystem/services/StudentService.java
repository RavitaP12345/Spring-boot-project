package com.mrcool.EmployeeManagementSystem.services;

import com.mrcool.EmployeeManagementSystem.entities.*;
import com.mrcool.EmployeeManagementSystem.models.StudentModel;
import com.mrcool.EmployeeManagementSystem.repositories.*;
import org.aspectj.util.IStructureModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private CollegeRepository collegeRepository;
    @Autowired
    private AddressRepository addressRepository;

    public ResponseEntity<?> saveStudentDetails(StudentModel studentModel) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(studentModel.getFirstName());
        studentEntity.setLastName(studentModel.getLastName());
        studentEntity.setSalutation(studentModel.getSalutation());
        List<AddressEntity> addressEntityList = new ArrayList<>();
        List<EmailEntity> emailEntities = new ArrayList<>();
        List<ContactEntity> contactEntities = new ArrayList<>();
        CollegeEntity collegeEntity = new CollegeEntity();
        studentModel.getAddresses().forEach(data->{
            AddressEntity address = new AddressEntity();
            address.setAddress(data.getAddress());
            address.setAddressType(data.getAddressType());
            address.setCity(data.getCity());
            address.setState(data.getState());
            address.setStudent(studentEntity);
            addressEntityList.add(address);

        });
        studentModel.getEmails().forEach(data->{
            EmailEntity emailEntity = new EmailEntity();
            emailEntity.setEmailAddress(data.getEmailAddress());
            emailEntity.setEmailType(data.getEmailType());
            emailEntity.setStudent(studentEntity);
            emailEntities.add(emailEntity);
        });
        studentModel.getContacts().forEach(data->{
            ContactEntity contactEntity = new ContactEntity();
            contactEntity.setContactNumber(data.getContactNumber());
            contactEntity.setContactType(data.getContactType());
            contactEntity.setStudent(studentEntity);
            contactEntities.add(contactEntity);
        });
        collegeEntity.setCollegeName(studentModel.getCollege().getCollegeName());
        collegeEntity.setCollegeAddress(studentModel.getCollege().getCollegeAddress());
        collegeEntity.setStudent(studentEntity);
        studentEntity.setAddressEntities(addressEntityList);
        studentEntity.setCollege(collegeEntity);
        studentEntity.setContactEntities(contactEntities);
        studentEntity.setEmailEntities(emailEntities);
        studentRepository.save(studentEntity);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}

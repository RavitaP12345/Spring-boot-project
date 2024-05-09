package com.example.EmailNotification.services;

import com.example.EmailNotification.entities.StudentEntity;
import com.example.EmailNotification.models.StudentModel;
import com.example.EmailNotification.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    JavaMailSender javaMailSender;
    @Transactional
    public ResponseEntity<?> saveStudentRegistration(StudentModel studentModel) {
        StudentEntity student = new StudentEntity();
        student.setStudentName(studentModel.getStudentName());
        student.setStudentMobile(studentModel.getStudentMobile());
        student.setStudentEmail(studentModel.getStudentEmail());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(studentModel.getStudentEmail());
        message.setSubject("Student Registration.");
        message.setText("Your Registration has done successfully.");
        String status = null;
        try{
            javaMailSender.send(message);
            status = "success";
        }catch (Exception e){
            status = "failed";
        }
        if(status.equalsIgnoreCase("success")){
            studentRepository.save(student);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Failed", HttpStatus.FORBIDDEN);
        }

    }
}

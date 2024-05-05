package com.example.crudoperationexample.services;

import com.example.crudoperationexample.entities.StudentEntity;
import com.example.crudoperationexample.models.StudentModel;
import com.example.crudoperationexample.repositories.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import nu.pattern.OpenCV;
import org.opencv.core.*;
import org.opencv.features2d.DescriptorMatcher;
import org.opencv.features2d.ORB;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Transactional
    public ResponseEntity<?> saveStudentDetails(StudentModel studentModel) {
        try{
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setStudentName(studentModel.getStudentName());
            studentEntity.setStudentEmail(studentModel.getStudentEmail());
            studentEntity.setStudentAddress(studentModel.getStudentAddress());
            studentEntity.setStudentEmail(studentModel.getStudentEmail());
            studentEntity.setStudentCity(studentModel.getStudentCity());
            studentEntity.setStudentState(studentModel.getStudentState());
            studentEntity.setStudentCountry(studentModel.getStudentCountry());
            studentEntity.setStudentMobile(studentModel.getStudentMobile());
            studentRepository.save(studentEntity);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Failed", HttpStatus.FORBIDDEN);
        }
    }


    public List<StudentModel> getAllStudentDetails() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentModel> studentModels = new ArrayList<>();
        studentEntities.forEach(data->{
            StudentModel studentModel = new StudentModel();
            studentModel.setId(data.getId());
            studentModel.setStudentName(data.getStudentName());
            studentModel.setStudentEmail(data.getStudentEmail());
            studentModel.setStudentMobile(data.getStudentMobile());
            studentModel.setStudentAddress(data.getStudentAddress());
            studentModel.setStudentCity(data.getStudentCity());
            studentModel.setStudentCountry(data.getStudentCountry());
            studentModel.setStudentState(data.getStudentState());
            studentModels.add(studentModel);
        });
        return studentModels;
    }


    public StudentModel getStudentDetailsById(String studentId) {
        StudentModel studentModel = new StudentModel();
        try{
            StudentEntity studentEntity = studentRepository.findById(Long.valueOf(studentId)).get();
            studentModel.setId(studentEntity.getId());
            studentModel.setStudentName(studentEntity.getStudentName());
            studentModel.setStudentEmail(studentEntity.getStudentEmail());
            studentModel.setStudentMobile(studentEntity.getStudentMobile());
            studentModel.setStudentAddress(studentEntity.getStudentAddress());
            studentModel.setStudentCity(studentEntity.getStudentCity());
            studentModel.setStudentState(studentEntity.getStudentState());
            studentModel.setStudentCountry(studentEntity.getStudentCountry());
            return studentModel;
        }catch (Exception e){
            return studentModel;
        }
    }


    public ResponseEntity<?> deleteStudentDetailsByStudentId(String studentId) {
        try{
            StudentEntity studentEntity = studentRepository.findById(Long.valueOf(studentId)).get();
            studentRepository.delete(studentEntity);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Failed", HttpStatus.FORBIDDEN);
        }
    }
    @Transactional
    public ResponseEntity<?> updateStudentDetailsByStudentId(StudentModel studentModel) {
        if(studentModel.getId()!=null){
            try{
                StudentEntity studentEntity = studentRepository.findById(studentModel.getId()).get();
                studentEntity.setStudentName(studentModel.getStudentName());
                studentEntity.setStudentEmail(studentModel.getStudentEmail());
                studentEntity.setStudentMobile(studentModel.getStudentMobile());
                studentEntity.setStudentCity(studentModel.getStudentCity());
                studentEntity.setStudentAddress(studentModel.getStudentAddress());
                studentEntity.setStudentState(studentModel.getStudentState());
                studentRepository.save(studentEntity);
                return new ResponseEntity<>("Success", HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>("Failed", HttpStatus.FORBIDDEN);
            }

        }else {
            return new ResponseEntity<>("Student id is not present in model class.", HttpStatus.FORBIDDEN);
        }
    }
}

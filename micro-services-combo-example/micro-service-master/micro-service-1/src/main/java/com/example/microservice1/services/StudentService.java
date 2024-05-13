package com.example.microservice1.services;

import com.example.microservice1.entities.CollegeEntity;
import com.example.microservice1.entities.StudentEntity;
import com.example.microservice1.models.CollegeModel;
import com.example.microservice1.models.StudentModel;
import com.example.microservice1.repositories.CollegeRepository;
import com.example.microservice1.repositories.StudentRepository;
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
    private CollegeRepository collegeRepository;
    public ResponseEntity<?> saveStudentDetailsWithCollege(StudentModel studentModel) {
        StudentEntity student = new StudentEntity();
        student.setStudentName(studentModel.getStudentName());
        student.setStudentEmail(studentModel.getStudentEmail());
        student.setStudentMobile(studentModel.getStudentMobile());
        CollegeEntity college = new CollegeEntity();
        college.setCollegeName(studentModel.getCollege().getCollegeName());
        college.setCollegeLocation(studentModel.getCollege().getCollegeLocation());
        college.setStudent(student);
        student.setCollege(college);
        studentRepository.save(student);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public List<StudentModel> getAllStudentDetailsWithCollegeDetails() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentModel> studentModels = new ArrayList<>();
        studentEntities.forEach(data->{
            StudentModel studentModel = new StudentModel();
            studentModel.setStudentId(data.getStudentId());
            studentModel.setStudentEmail(data.getStudentEmail());
            studentModel.setStudentMobile(data.getStudentMobile());
            studentModel.setStudentName(data.getStudentName());
            CollegeModel collegeModel = new CollegeModel();
            collegeModel.setCollegeId(data.getCollege().getCollegeId());
            collegeModel.setCollegeLocation(data.getCollege().getCollegeLocation());
            collegeModel.setCollegeLocation(data.getCollege().getCollegeLocation());
            studentModel.setCollege(collegeModel);
            studentModels.add(studentModel);
        });
        return studentModels;
    }

    public StudentModel getStudentDetailsByStudentId(String studentId) {
        StudentModel studentModel = new StudentModel();
        StudentEntity studentEntity = studentRepository.findByStudentId(Long.valueOf(studentId));
        CollegeModel collegeModel = new CollegeModel();
        studentModel.setStudentId(studentEntity.getStudentId());
        studentModel.setStudentName(studentEntity.getStudentName());
        studentModel.setStudentEmail(studentEntity.getStudentEmail());
        studentModel.setStudentMobile(studentEntity.getStudentMobile());
        collegeModel.setCollegeId(studentEntity.getCollege().getCollegeId());
        collegeModel.setCollegeName(studentEntity.getCollege().getCollegeName());
        collegeModel.setCollegeLocation(studentEntity.getCollege().getCollegeLocation());
        studentModel.setCollege(collegeModel);
        return studentModel;
    }

    public ResponseEntity<?> deleteStudentDetailsByStudentId(String studentId) {
        StudentEntity studentEntity = studentRepository.findByStudentId(Long.valueOf(studentId));
        studentRepository.delete(studentEntity);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<?> updateStudentDetails(StudentModel studentModel) {
        StudentEntity student = studentRepository.findByStudentId(studentModel.getStudentId());
        student.setStudentName(studentModel.getStudentName());
        student.setStudentEmail(studentModel.getStudentEmail());
        student.setStudentMobile(studentModel.getStudentMobile());
        student.getCollege().setCollegeName(studentModel.getCollege().getCollegeName());
        student.getCollege().setCollegeLocation(studentModel.getCollege().getCollegeLocation());
        collegeRepository.save(student.getCollege());
        studentRepository.save(student);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public CollegeModel getCollegeDetailsByStudentId(String studentId) {
        StudentEntity student = studentRepository.findByStudentId(Long.valueOf(studentId));
        CollegeEntity college = collegeRepository.findByStudent(student);
        CollegeModel collegeModel = new CollegeModel();
        collegeModel.setCollegeId(college.getCollegeId());
        collegeModel.setCollegeName(college.getCollegeLocation());
        collegeModel.setCollegeLocation(college.getCollegeLocation());
        return collegeModel;
    }

    public List<CollegeModel> getAllCollegeListOfStudents() {
        List<CollegeEntity> collegeEntities = collegeRepository.findAll();
        List<CollegeModel> collegeModels = new ArrayList<>();
        collegeEntities.forEach(data->{
            CollegeModel collegeModel = new CollegeModel();
            collegeModel.setCollegeId(data.getCollegeId());
            collegeModel.setCollegeLocation(data.getCollegeLocation());
            collegeModel.setCollegeName(data.getCollegeName());
            collegeModels.add(collegeModel);
        });
        return collegeModels;
    }
}

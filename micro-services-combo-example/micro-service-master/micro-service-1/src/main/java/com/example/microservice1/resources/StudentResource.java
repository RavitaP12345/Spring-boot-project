package com.example.microservice1.resources;

import com.example.microservice1.models.CollegeModel;
import com.example.microservice1.models.StudentModel;
import com.example.microservice1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/stdd")
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudentDetailsWithCollege")
    public ResponseEntity<?> saveStudentDetailsWithCollege(@RequestBody StudentModel studentModel){
        return studentService.saveStudentDetailsWithCollege(studentModel);
    }
    @GetMapping("/getAllStudentDetailsWithCollegeDetails")
    public List<StudentModel> getAllStudentDetailsWithCollegeDetails(){
        return studentService.getAllStudentDetailsWithCollegeDetails();
    }
    @GetMapping("/getStudentDetailsByStudentId/{studentId}")
    public StudentModel getStudentDetailsByStudentId(@PathVariable String studentId){
        return studentService.getStudentDetailsByStudentId(studentId);
    }
    @DeleteMapping("/deleteStudentDetailsByStudentId/{studentId}")
    public ResponseEntity<?> deleteStudentDetailsByStudentId(@PathVariable String studentId){
        return studentService.deleteStudentDetailsByStudentId(studentId);
    }
    @PutMapping("/updateStudentDetails")
    public ResponseEntity<?> updateStudentDetails(@RequestBody StudentModel studentModel) {
        return studentService.updateStudentDetails(studentModel);
    }
    @GetMapping("/getCollegeDetailsByStudentId/{studentId}")
    public CollegeModel getCollegeDetailsByStudentId(@PathVariable String studentId){
        return studentService.getCollegeDetailsByStudentId(studentId);
    }
    @GetMapping("/getAllCollegeListOfStudents")
    public List<CollegeModel> getAllCollegeListOfStudents(){
        return studentService.getAllCollegeListOfStudents();
    }
}

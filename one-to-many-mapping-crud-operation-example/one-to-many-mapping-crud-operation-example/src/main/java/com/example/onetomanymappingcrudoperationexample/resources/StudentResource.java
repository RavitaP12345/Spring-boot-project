package com.example.onetomanymappingcrudoperationexample.resources;

import com.example.onetomanymappingcrudoperationexample.models.StudentModel;
import com.example.onetomanymappingcrudoperationexample.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/std")
public class StudentResource {
    @Autowired
    StudentService studentService;

    @PostMapping("/saveStudentDetails")
    public ResponseEntity<?> saveStudentDetails(@RequestBody StudentModel studentModel){
        return studentService.saveStudentDetails(studentModel);
    }
    @GetMapping("/getAllStudentDetails")
    public List<StudentModel> getAllStudentDetails(){
        return studentService.getAllStudentDetails();
    }
    @GetMapping("/getStudentDetailsByStudentId/{studentId}")
    public StudentModel getStudentDetailsByStudentId(@PathVariable String studentId){
        return studentService.getStudentDetailsByStudentId(studentId);
    }
    @PostMapping("/updateStudentDetails")
    public ResponseEntity<?> updateStudentDetails(@RequestBody StudentModel studentModel){
        return studentService.updateStudentDetails(studentModel);
    }
    @DeleteMapping("/deleteStudentDetailsByStudentId/{studentId}")
    public ResponseEntity<?> deleteStudentDetailsByStudentId(@PathVariable String studentId){
        return studentService.deleteStudentDetailsByStudentId(studentId);
    }

}

package com.example.crudoperationexample.resources;

import com.example.crudoperationexample.models.StudentModel;
import com.example.crudoperationexample.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/std")
public class StudentResource {
    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudentDetails")
    public ResponseEntity<?> saveStudentDetails(@RequestBody @Valid StudentModel studentModel, BindingResult bindingResult){
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrorList){
                linkedHashMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(linkedHashMap);
        }else {
            return studentService.saveStudentDetails(studentModel);
        }
    }

    @GetMapping("/getAllStudentDetails")
    public List<StudentModel> getAllStudentDetails(){
        return studentService.getAllStudentDetails();
    }

    @GetMapping("/getStudentDetailsById/{studentId}")
    public StudentModel getStudentDetailsById(@PathVariable String studentId){
        return studentService.getStudentDetailsById(studentId);
    }

    @DeleteMapping("/deleteStudentDetailsByStudentId/{studentId}")
    public ResponseEntity<?> deleteStudentDetailsByStudentId(@PathVariable String studentId){
        return studentService.deleteStudentDetailsByStudentId(studentId);
    }

    @PostMapping("/updateStudentDetailsByStudentId")
    public ResponseEntity<?> updateStudentDetailsByStudentId(@RequestBody StudentModel studentModel){
        return studentService.updateStudentDetailsByStudentId(studentModel);
    }







}

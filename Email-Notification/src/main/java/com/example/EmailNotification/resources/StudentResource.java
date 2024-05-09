package com.example.EmailNotification.resources;

import com.example.EmailNotification.models.StudentModel;
import com.example.EmailNotification.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/std")
public class StudentResource {
    @Autowired
    StudentService studentService;

    @PostMapping("/saveStudentRegistration")
    public ResponseEntity<?> saveStudentRegistration(@Valid @RequestBody StudentModel studentModel, BindingResult bindingResult){
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if(bindingResult.hasErrors()){
            for (FieldError error : bindingResult.getFieldErrors()){
                linkedHashMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(linkedHashMap, HttpStatus.FORBIDDEN);
        }else {
            return studentService.saveStudentRegistration(studentModel);
        }

    }
}

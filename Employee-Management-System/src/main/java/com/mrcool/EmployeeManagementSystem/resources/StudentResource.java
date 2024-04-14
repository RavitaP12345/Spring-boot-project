package com.mrcool.EmployeeManagementSystem.resources;

import com.mrcool.EmployeeManagementSystem.models.StudentModel;
import com.mrcool.EmployeeManagementSystem.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.LinkedHashSet;
import java.util.List;

@RestController
@RequestMapping("/std")
public class StudentResource {
    @Autowired
    StudentService studentService;

    @PostMapping("/saveStudentDetails")
    public ResponseEntity<?> saveStudentDetails(@Valid @RequestBody StudentModel studentModel, BindingResult bindingResult){
        LinkedHashSet<String> errors = new LinkedHashSet<String>();
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(error->{
                String abc = error.getDefaultMessage();
                errors.add(abc);

            });
            return ResponseEntity.badRequest().body(errors);

        }else {
            return studentService.saveStudentDetails(studentModel);
        }
    }

}

package com.example.opencvproject.resources;

import com.example.opencvproject.models.EmployeeModel;
import com.example.opencvproject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeResource {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getEmployeeDetailsByProfilePhoto")
    public EmployeeModel getEmployeeDetailsByProfilePhoto(@RequestParam("photo") String imagePath){
        return employeeService.getEmployeeDetailsByProfilePhoto(imagePath);
    }

}

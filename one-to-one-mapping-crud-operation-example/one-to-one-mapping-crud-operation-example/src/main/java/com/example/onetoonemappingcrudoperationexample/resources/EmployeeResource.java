package com.example.onetoonemappingcrudoperationexample.resources;

import com.example.onetoonemappingcrudoperationexample.models.EmployeeModel;
import com.example.onetoonemappingcrudoperationexample.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeResource {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/saveEmployeeDetails")
    public ResponseEntity<?> saveEmployeeDetails(@RequestBody EmployeeModel employeeModel){
        return employeeService.saveEmployeeDetails(employeeModel);
    }
    @GetMapping("/getAllEmployeeDetails")
    public List<EmployeeModel> getAllEmployeeDetails(){
        return employeeService.getAllEmployeeDetails();
    }
    @GetMapping("/getEmployeeDetailsByEmployeeId/{employeeId}")
    public EmployeeModel getEmployeeDetailsByEmployeeId(@PathVariable String employeeId){
        return employeeService.getEmployeeDetailsByEmployeeId(employeeId);
    }
    @DeleteMapping("/deleteEmployeeDetailsByEmployeeId/{employeeId}")
    public ResponseEntity<?> deleteEmployeeDetailsByEmployeeId(@PathVariable String employeeId){
        return employeeService.deleteEmployeeDetailsByEmployeeId(employeeId);
    }
    @PostMapping("/updateEmployeeDetails")
    public ResponseEntity<?> updateEmployeeDetails(@RequestBody EmployeeModel employeeModel){
        return employeeService.updateEmployeeDetails(employeeModel);
    }
}

package com.example.onetoonemappingcrudoperationexample.services;

import com.example.onetoonemappingcrudoperationexample.entities.EmployeeEntity;
import com.example.onetoonemappingcrudoperationexample.entities.LaptopEntity;
import com.example.onetoonemappingcrudoperationexample.models.EmployeeModel;
import com.example.onetoonemappingcrudoperationexample.models.LaptopModel;
import com.example.onetoonemappingcrudoperationexample.repositories.EmployeeRepository;
import com.example.onetoonemappingcrudoperationexample.repositories.LaptopRepository;
import jakarta.transaction.Transactional;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    LaptopRepository laptopRepository;
    @Transactional
    public ResponseEntity<?> saveEmployeeDetails(EmployeeModel employeeModel) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        LaptopEntity laptopEntity = new LaptopEntity();
        employeeEntity.setName(employeeModel.getName());
        employeeEntity.setDesignation(employeeModel.getDesignation());
        employeeEntity.setDepartment(employeeModel.getDepartment());
        employeeEntity.setCompany(employeeModel.getCompany());
        laptopEntity.setName(employeeModel.getLaptop().getName());
        laptopEntity.setBrand(employeeModel.getLaptop().getBrand());
        laptopEntity.setModel(employeeModel.getLaptop().getModel());
        laptopEntity.setEmployee(employeeEntity);
        employeeEntity.setLaptop(laptopEntity);
        employeeRepository.save(employeeEntity);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public List<EmployeeModel> getAllEmployeeDetails() {
        List<EmployeeModel> employeeModels = new ArrayList<>();
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        employeeEntities.forEach(data->{
            EmployeeModel employeeModel = new EmployeeModel();
            LaptopModel laptopModel = new LaptopModel();
            employeeModel.setEmployeeId(data.getEmployeeId());
            employeeModel.setName(data.getName());
            employeeModel.setCompany(data.getCompany());
            employeeModel.setDepartment(data.getDepartment());
            employeeModel.setDesignation(data.getDesignation());
            laptopModel.setLaptopId(data.getLaptop().getLaptopId());
            laptopModel.setName(data.getLaptop().getName());
            laptopModel.setModel(data.getLaptop().getModel());
            laptopModel.setBrand(data.getLaptop().getBrand());
            employeeModel.setLaptop(laptopModel);
            employeeModels.add(employeeModel);
        });
        return employeeModels;
    }

    public EmployeeModel getEmployeeDetailsByEmployeeId(String employeeId) {
        EmployeeEntity employeeEntity = employeeRepository.findByEmployeeId(Long.valueOf(employeeId));
        EmployeeModel employeeModel = new EmployeeModel();
        LaptopModel laptopModel = new LaptopModel();
        employeeModel.setEmployeeId(employeeEntity.getEmployeeId());
        employeeModel.setName(employeeEntity.getName());
        employeeModel.setDepartment(employeeEntity.getDepartment());
        employeeModel.setDesignation(employeeEntity.getDesignation());
        employeeModel.setCompany(employeeEntity.getCompany());
        laptopModel.setLaptopId(employeeEntity.getLaptop().getLaptopId());
        laptopModel.setName(employeeEntity.getLaptop().getName());
        laptopModel.setBrand(employeeEntity.getLaptop().getBrand());
        laptopModel.setModel(employeeEntity.getLaptop().getModel());
        employeeModel.setLaptop(laptopModel);
        return employeeModel;
    }
    @Transactional
    public ResponseEntity<?> deleteEmployeeDetailsByEmployeeId(String employeeId) {
        EmployeeEntity employeeEntity = employeeRepository.findByEmployeeId(Long.valueOf(employeeId));
        employeeRepository.delete(employeeEntity);
        return new ResponseEntity<>("Deleted.", HttpStatus.OK);
    }

    public ResponseEntity<?> updateEmployeeDetails(EmployeeModel employeeModel) {
        EmployeeEntity employeeEntity = employeeRepository.findByEmployeeId(employeeModel.getEmployeeId());
        employeeEntity.setName(employeeModel.getName());
        employeeEntity.setDesignation(employeeModel.getDesignation());
        employeeEntity.setDepartment(employeeModel.getDepartment());
        employeeEntity.setCompany(employeeModel.getCompany());
        LaptopEntity laptopEntity = laptopRepository.findByLaptopId(employeeEntity.getLaptop().getLaptopId());
        laptopEntity.setName(employeeModel.getLaptop().getName());
        laptopEntity.setModel(employeeModel.getLaptop().getModel());
        laptopEntity.setBrand(employeeModel.getLaptop().getBrand());
        employeeEntity.setLaptop(laptopEntity);
        employeeRepository.save(employeeEntity);
        return new ResponseEntity<>("Updated.", HttpStatus.OK);
    }
}

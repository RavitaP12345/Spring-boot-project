package com.example.onetoonemappingcrudoperationexample.repositories;

import com.example.onetoonemappingcrudoperationexample.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    EmployeeEntity findByEmployeeId(Long aLong);
}

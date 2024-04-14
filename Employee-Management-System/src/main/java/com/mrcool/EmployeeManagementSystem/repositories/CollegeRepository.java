package com.mrcool.EmployeeManagementSystem.repositories;

import com.mrcool.EmployeeManagementSystem.entities.CollegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<CollegeEntity, Long> {
}

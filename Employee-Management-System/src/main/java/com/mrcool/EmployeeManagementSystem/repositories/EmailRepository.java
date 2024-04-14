package com.mrcool.EmployeeManagementSystem.repositories;

import com.mrcool.EmployeeManagementSystem.entities.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
}

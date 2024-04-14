package com.mrcool.EmployeeManagementSystem.repositories;

import com.mrcool.EmployeeManagementSystem.entities.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
}

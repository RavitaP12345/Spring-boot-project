package com.mrcool.EmployeeManagementSystem.repositories;

import com.mrcool.EmployeeManagementSystem.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}

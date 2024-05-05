package com.example.opencvproject.repositories;

import com.example.opencvproject.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}

package com.example.microservice1.repositories;

import com.example.microservice1.entities.CollegeEntity;
import com.example.microservice1.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<CollegeEntity, Long> {
    CollegeEntity findByStudent(StudentEntity student);
}

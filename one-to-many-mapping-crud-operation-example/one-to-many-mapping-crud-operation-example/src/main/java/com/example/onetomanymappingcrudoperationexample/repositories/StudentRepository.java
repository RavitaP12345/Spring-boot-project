package com.example.onetomanymappingcrudoperationexample.repositories;

import com.example.onetomanymappingcrudoperationexample.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    StudentEntity findByStudentId(Long aLong);
}

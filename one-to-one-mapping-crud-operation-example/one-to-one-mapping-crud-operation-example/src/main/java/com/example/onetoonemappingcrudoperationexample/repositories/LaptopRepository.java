package com.example.onetoonemappingcrudoperationexample.repositories;

import com.example.onetoonemappingcrudoperationexample.entities.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<LaptopEntity, Long> {
    LaptopEntity findByLaptopId(Long laptopId);
}

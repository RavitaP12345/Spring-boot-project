package com.example.onetomanymappingcrudoperationexample.repositories;

import com.example.onetomanymappingcrudoperationexample.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}

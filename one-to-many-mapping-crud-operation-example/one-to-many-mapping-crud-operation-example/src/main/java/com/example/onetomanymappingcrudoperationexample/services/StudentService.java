package com.example.onetomanymappingcrudoperationexample.services;

import com.example.onetomanymappingcrudoperationexample.entities.BookEntity;
import com.example.onetomanymappingcrudoperationexample.entities.StudentEntity;
import com.example.onetomanymappingcrudoperationexample.models.BookModel;
import com.example.onetomanymappingcrudoperationexample.models.StudentModel;
import com.example.onetomanymappingcrudoperationexample.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Transactional
    public ResponseEntity<?> saveStudentDetails(StudentModel studentModel) {
        StudentEntity student = new StudentEntity();
        student.setStudentName(studentModel.getStudentName());
        student.setStudentEmail(studentModel.getStudentEmail());
        student.setStudentMobileNumber(studentModel.getStudentMobileNumber());
        List<BookEntity> bookEntities = new ArrayList<>();
        studentModel.getBooks().forEach(data->{
            BookEntity book = new BookEntity();
            book.setBookName(data.getBookName());
            book.setBookType(data.getBookType());
            book.setAuthor(data.getAuthor());
            book.setStudent(student);
            bookEntities.add(book);
        });
        student.setBooks(bookEntities);
        studentRepository.save(student);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public List<StudentModel> getAllStudentDetails() {
        List<StudentModel> studentModels = new ArrayList<>();
        List<StudentEntity> studentEntities = studentRepository.findAll();
        studentEntities.forEach(data->{
            StudentModel studentModel = new StudentModel();
            studentModel.setStudentId(data.getStudentId());
            studentModel.setStudentEmail(data.getStudentEmail());
            studentModel.setStudentMobileNumber(data.getStudentMobileNumber());
            List<BookModel> bookModels = new ArrayList<>();
            data.getBooks().forEach(book->{
                BookModel bookModel = new BookModel();
                bookModel.setBookId(book.getBookId());
                bookModel.setBookName(book.getBookName());
                bookModel.setAuthor(book.getAuthor());
                bookModel.setBookType(book.getBookType());
                bookModels.add(bookModel);
            });
            studentModel.setBooks(bookModels);
            studentModels.add(studentModel);
        });
        return studentModels;
    }

    public StudentModel getStudentDetailsByStudentId(String studentId) {
        StudentEntity student = studentRepository.findByStudentId(Long.valueOf(studentId));
        List<BookModel> books = new ArrayList<>();
        StudentModel studentModel = new StudentModel();
        studentModel.setStudentId(student.getStudentId());
        studentModel.setStudentName(student.getStudentName());
        studentModel.setStudentMobileNumber(student.getStudentMobileNumber());
        studentModel.setStudentEmail(student.getStudentEmail());
        student.getBooks().forEach(data->{
            BookModel bookModel = new BookModel();
            bookModel.setBookId(data.getBookId());
            bookModel.setBookName(data.getBookName());
            bookModel.setBookType(data.getBookType());
            bookModel.setAuthor(data.getAuthor());
            books.add(bookModel);
        });
        studentModel.setBooks(books);
        return studentModel;
    }
    @Transactional
    public ResponseEntity<?> updateStudentDetails(StudentModel studentModel) {
        StudentEntity student = studentRepository.findByStudentId(studentModel.getStudentId());
        List<BookEntity> bookEntities = new ArrayList<>();
        student.setStudentName(studentModel.getStudentName());
        student.setStudentEmail(studentModel.getStudentEmail());
        student.setStudentMobileNumber(studentModel.getStudentMobileNumber());
        student.getBooks().forEach(data->{
            studentModel.getBooks().forEach(model->{
                data.setBookName(model.getBookName());
                data.setAuthor(model.getAuthor());
                data.setBookType(model.getBookType());
            });
            bookEntities.add(data);
        });
        student.setBooks(bookEntities);
        studentRepository.save(student);
        return new ResponseEntity<>("updated.", HttpStatus.OK);
    }

    public ResponseEntity<?> deleteStudentDetailsByStudentId(String studentId) {
        StudentEntity studentEntity = studentRepository.findByStudentId(Long.valueOf(studentId));
        studentRepository.delete(studentEntity);
        return new ResponseEntity<>("Deleted.", HttpStatus.OK);
    }
}

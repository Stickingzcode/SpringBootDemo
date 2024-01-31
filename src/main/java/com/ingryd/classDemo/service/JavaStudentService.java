package com.ingryd.classDemo.service;

import com.ingryd.classDemo.exception.StudentNotFoundException;
import com.ingryd.classDemo.model.JavaStudent;
import com.ingryd.classDemo.repository.JavaStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Service
public class JavaStudentService {

    @Autowired
    private JavaStudentRepository javaStudentRepository;

    public ResponseEntity<JavaStudent> saveStudent(JavaStudent javaStudent) {
        javaStudentRepository.save(javaStudent);
        return new ResponseEntity<>(javaStudent, HttpStatus.CREATED);
//        return ResponseEntity.ok(javaStudent);
    }

    public ResponseEntity<List<JavaStudent>> saveAllStudents(List<JavaStudent> javaStudentList){
        return new ResponseEntity<>(javaStudentRepository.saveAll(javaStudentList), HttpStatus.CREATED);
    }

    public ResponseEntity<List<JavaStudent>> getAllStudent() {
        return ResponseEntity.ok(javaStudentRepository.findAll());
    }

    public ResponseEntity<JavaStudent> getStudentById(int id) {
//        JavaStudent student = javaStudentRepository.findById(id).orElse(null);
        return ResponseEntity.ok(javaStudentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Java student not found")));
    }

//    public ResponseEntity<JavaStudent> getStudentByEmail( String email){
//        JavaStudent student = javaStudentRepository.findOne(email).orElseThrow(() -> new StudentNotFoundException(String.format("Java student with %s was not found", email)));
//        return ResponseEntity.ok(student);
//  }
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        javaStudentRepository.deleteById(id);
        return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
    }

//    public ResponseEntity<JavaStudent> updateStudent(@PathVariable int id){
//
//    }
}

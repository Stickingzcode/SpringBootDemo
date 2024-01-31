package com.ingryd.classDemo.controller;

import com.ingryd.classDemo.model.JavaStudent;
import com.ingryd.classDemo.model.JavaStudentResource;
import com.ingryd.classDemo.repository.JavaStudentRepository;
import com.ingryd.classDemo.service.JavaStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class JavaStudentController {

    @Autowired
    private JavaStudentService javaStudentService;

    @PostMapping("/students")
    public ResponseEntity<JavaStudent> saveStudent(@RequestBody @Valid JavaStudent javaStudent){
        javaStudentService.saveStudent(javaStudent);
        return new ResponseEntity<>(javaStudent, HttpStatus.CREATED);
//        return ResponseEntity.ok(javaStudent);
    }

    @GetMapping("/students")
    public ResponseEntity<List<JavaStudent>> getAllStudent(){
//        or return ResponseEntity.ok(javaStudentRepository.findAll());
        return new ResponseEntity<>(javaStudentService.getAllStudent().getBody(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<JavaStudent> getStudentById(@PathVariable int id){
//        JavaStudent student = javaStudentRepository.findById(id).orElse(null);
        return ResponseEntity.ok(javaStudentService.getStudentById(id).getBody());
    }

//    @GetMapping("/students/{id}")
//    public Optional<JavaStudent> getAStudentById(@PathVariable int id){
//        return javaStudentService.getStudentById(id);
////        this method has to return an optional
//    }

    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable int id, JavaStudent javaStudent){
        return null;
//        this method should not return null, there should be an update method in the service class
    }

//    @GetMapping("/students/{email}")
//    public ResponseEntity<JavaStudent> getStudentByEmail(@PathVariable String email){
////        javaStudentRepository.findBy(email);
//        return ResponseEntity.ok(javaStudentRepository.findByEmail)
//    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        javaStudentService.deleteStudent(id);
        return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
    }

//    @GetMapping("student/{id}")
//    public ResponseEntity<JavaStudentResource> getStudentResource(@PathVariable int id){
//        JavaStudentResource javaStudentResource = new JavaStudentResource();
//        JavaStudent javaStudent = getStudentById(id).getBody();
//        javaStudentResource.setJavaStudent(javaStudent);
//        Link idLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(JavaStudentController.class).update)
//    }
}

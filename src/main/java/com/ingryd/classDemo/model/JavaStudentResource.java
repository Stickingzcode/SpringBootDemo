package com.ingryd.classDemo.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class JavaStudentResource extends RepresentationModel<JavaStudentResource> {
    private JavaStudent javaStudent;
//    this class should extend RepresentationalModel that contains JavaStudent class
}

package com.ingryd.classDemo.repository;

import com.ingryd.classDemo.model.JavaStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JavaStudentRepository extends JpaRepository<JavaStudent, Integer> {
}

package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	Page<Student> findByClass_NameAndTeacher_LastName(String className, String teacherLastName, Pageable pageable);

    // Get students by class name with pagination
    Page<Student> findByClass_Name(String className, Pageable pageable);

    // Get students by teacher last name with pagination
    Page<Student> findByTeacher_LastName(String teacherLastName, Pageable pageable);
    
    Student findByUsername(String firstName);

}

package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class StudentController {

	
	 @Autowired
	  private StudentRepository studentRepository;

	    @GetMapping("/students")
	    public ResponseEntity<List<Student>> getStudents(@RequestParam(value = "className", required = false) String className,
	                                                     @RequestParam(value = "teacherFullName", required = false) String teacherFullName,
	                                                     @RequestParam(value = "page", defaultValue = "0") int page,
	                                                     @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
	        Pageable pageable = PageRequest.of(page, pageSize);
	        Page<Student> studentsPage;

	        if (className != null && teacherFullName != null) {
	            studentsPage = studentRepository.findByClass_NameAndTeacher_LastName(className, teacherFullName, pageable);
	        } else if (className != null) {
	            studentsPage = studentRepository.findByClass_Name(className, pageable);
	        } else if (teacherFullName != null) {
	            studentsPage = studentRepository.findByTeacher_LastName(teacherFullName, pageable);
	        } else {
	            studentsPage = studentRepository.findAll(pageable);
	        }

	        List<Student> students = studentsPage.getContent();
	        return ResponseEntity.ok().body(students);
	    }
}

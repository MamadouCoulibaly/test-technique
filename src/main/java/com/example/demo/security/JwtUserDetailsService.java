package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	 @Autowired
	    private StudentRepository studentRepository; 

	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        // Retrieve Student from the database based on the provided username
	        Student student = studentRepository.findByUsername(username);
	        if (student == null) {
	            throw new UsernameNotFoundException("User not found with username: " + username);
	        }

	        // Create a UserDetails object using the retrieved student
	        UserDetails userDetails = User.builder()
	                .username(student.getFirstName())
	                .password(student.getLastName())
	                .roles("STUDENT")
	                .build();

	        return userDetails;
	    }}
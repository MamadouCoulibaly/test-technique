package com.example.demo.test;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DataJpaTest
public class StudentRepositoryTests {

    @InjectMocks
    private StudentRepository studentRepository;

    @MockBean
    private StudentRepository studentRepositoryMock;

    @Test
    public void testFindByClass_NameAndTeacher_LastName() {
        String className = "ClassA";
        String teacherLastName = "Mamadou";
        Pageable pageable = PageRequest.of(0, 10);

        // Mock the repository method
        // probleme de compatibilite de version
        /*when(studentRepositoryMock.findByClass_NameAndTeacher_LastName(className, teacherLastName, pageable))
                .thenReturn(Page.empty());*/

        // Call the actual repository method
        Page<Student> result = studentRepository.findByClass_NameAndTeacher_LastName(className, teacherLastName, pageable);

        // Verify the result
        assertThat(result).isEmpty();
    }

    @Test
    public void testFindByClass_Name() {
        String className = "ClassA";
        Pageable pageable = PageRequest.of(0, 10);

        // Mock the repository method
        // probleme de compatibilite de version
       /* when(studentRepositoryMock.findByClass_Name(className, pageable))
                .thenReturn(Page.empty());*/

        // Call the actual repository method
        Page<Student> result = studentRepository.findByClass_Name(className, pageable);

        // Verify the result
        assertThat(result).isEmpty();
    }

    @Test
    public void testFindByTeacher_LastName() {
        String teacherLastName = "Mamadou";
        Pageable pageable = PageRequest.of(0, 10);

        // Mock the repository method
       // probleme de compatibilite de version
        /*when(studentRepositoryMock.findByTeacher_LastName(teacherLastName, pageable))
                .thenReturn(Page.empty());*/

        // Call the actual repository method
        Page<Student> result = studentRepository.findByTeacher_LastName(teacherLastName, pageable);

        // Verify the result
        assertThat(result).isEmpty();
    }
}

package com.example.demo.service;

import com.example.demo.Exception.ValidationException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    private static StudentService studentService;
    private static StudentRepository studentRepository;

    @BeforeAll //do tego wszystko musi byc statyczne
    public static  void setup(){
        studentRepository= new StudentRepository();
        studentService = new StudentService(studentRepository);
    }
    @Test
    void shouldSaveNewStudent(){
        Student student = new Student(null,"Jan", "Kowalski");
        Student result = assertDoesNotThrow(()-> studentService.save(student));
        assertEquals(result.getName(), student.getName());
        assertEquals(result.getLastname(), student.getLastname());
    }
    @Test
    void shoulThrowValidationException(){
        Student student = new Student(null, "", "XYZ");
        ValidationException validationException =assertThrows(ValidationException.class, ()-> studentService.save(student));
        assertEquals(validationException.getMessage(),"Student name cannot be blank");
    }
}
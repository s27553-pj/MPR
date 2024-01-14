package com.example.demo.controller;

import com.example.demo.Exception.ValidationException;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;
    @PostMapping //do tworzenia nowych zasobow
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        try {
            Student result = studentService.save(student);
            return ResponseEntity.status(201).body(result);
        } catch (ValidationException exception){
            return ResponseEntity.badRequest().build();
        }
    }
@GetMapping
    public ResponseEntity<List<Student>> getAll(){
        List<Student> list = studentService.findAll();
        return ResponseEntity.ok(list);
}
}

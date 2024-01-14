package com.example.demo.service;

import com.example.demo.Exception.ValidationException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //wskazuje springowi ze ma utworzyc z niej obiekt
@AllArgsConstructor
public class StudentService {
    //wstrzykniecie repozytorium
    private StudentRepository studentRepository;
    public Student save(Student student){
        if (student.getName() == null || student.getName().isBlank()){
            throw new ValidationException("Student name cannot be blank");
        }
        if (student.getLastname() == null || student.getName().isBlank()){
            throw new ValidationException("Student lat name cannot be blank");
        }
       return studentRepository.save(student);
    }
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

}

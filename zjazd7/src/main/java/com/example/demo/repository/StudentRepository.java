package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //miejsce gdzie skladujemu studentow i ze jest to zarzadzane przez springa
public class StudentRepository {
    private List<Student> studentList = new ArrayList<>();

    public Student save(Student student) { //dodaje studenta do listy
        student.setId(studentList.size());
        studentList.add(student);
        return student;
    }

    public List<Student> findAll() {
        return studentList;
    }
    public void deleteAll(){
        studentList = new ArrayList<>();
    }

}
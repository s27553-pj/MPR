package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient

public class StudentControllerTest {
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @BeforeEach //czyszczenie
    public void clanup(){
        studentRepository.deleteAll();
    }

    @Test
    void shouldSaveNewStudent() throws JsonProcessingException{
        Student student = new Student(null, "XYZ", "XYZ");
        String json = objectMapper.writeValueAsString(student);
        webTestClient.post().uri("/student")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(json)
                .exchange()
                .expectStatus().isEqualTo(201)
                .expectBody(Student.class)
                .returnResult().getResponseBody();
    }
    @Test
    void shouldReturnaAllStudents(){
        Student student = new Student(null, "XYZ", "XYZ");
        studentRepository.save(student);
        List<Student> result = webTestClient.get().uri("/student")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Student.class)
                .returnResult().getResponseBody();
        assertEquals(result.get(0).getName(),student.getName());
        assertEquals(1,result.size());
    }
}

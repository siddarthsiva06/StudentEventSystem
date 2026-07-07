package com.example.studentservice.controller;

import com.example.studentservice.model.Student;
import com.example.studentservice.service.StudentService;
import com.example.studentservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.registerStudent(student));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {

        Student student = studentService.loginStudent(
                credentials.get("email"),
                credentials.get("password")
        );

        String token = jwtUtil.generateToken(student.getEmail());

        return ResponseEntity.ok(Map.of(
                "token", token,
                "rollNumber", student.getRollNumber(),
                "name", student.getName(),
                "email", student.getEmail()
        ));
    }

    @GetMapping("/roll/{rollNumber}")
    public ResponseEntity<?> getByRollNumber(@PathVariable String rollNumber) {
        return studentService.getByRollNumber(rollNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
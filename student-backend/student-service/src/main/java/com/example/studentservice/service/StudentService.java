package com.example.studentservice.service;

import com.example.studentservice.model.Student;
import com.example.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Student registerStudent(Student student) {

        if (repository.existsByEmail(student.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email already exists"
            );
        }

        if (repository.existsByRollNumber(student.getRollNumber())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Roll number already exists"
            );
        }

        student.setPassword(passwordEncoder.encode(student.getPassword()));

        return repository.save(student);
    }

    public Student loginStudent(String email, String password) {
        Student student = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, student.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return student;
    }

    public Optional<Student> getByRollNumber(String rollNumber) {
        return repository.findByRollNumber(rollNumber);
    }
}
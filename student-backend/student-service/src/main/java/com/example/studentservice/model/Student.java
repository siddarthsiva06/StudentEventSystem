package com.example.studentservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class Student {
    @Id
    private String id;

    @Indexed(unique = true)
    private String rollNumber;

    private String name;

    @Indexed(unique = true)
    private String email;
    private String password;
}
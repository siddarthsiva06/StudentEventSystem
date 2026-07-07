package com.example.eventservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "events")
public class StudentEvent {
    @Id
    private String id;
    private String rollNumber;
    private String studentName;
    private String eventName;
    private String eventLocation;
    private String eventDate;
    private String eventDescription;
}

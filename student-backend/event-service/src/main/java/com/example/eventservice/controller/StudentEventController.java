package com.example.eventservice.controller;

import com.example.eventservice.model.StudentEvent;
import com.example.eventservice.service.StudentEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "*")
public class StudentEventController {

    @Autowired
    private StudentEventService eventService;

    @PostMapping("/add")
    public ResponseEntity<StudentEvent> addEvent(
            @RequestHeader("Authorization") String token,
            @RequestBody StudentEvent event) {

        return ResponseEntity.ok(eventService.addEvent(event));
    }

    @GetMapping("/student/{rollNumber}")
    public ResponseEntity<List<StudentEvent>> getByRollNumber(@PathVariable String rollNumber) {
        return ResponseEntity.ok(eventService.getEventsByRollNumber(rollNumber));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentEvent>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }
}

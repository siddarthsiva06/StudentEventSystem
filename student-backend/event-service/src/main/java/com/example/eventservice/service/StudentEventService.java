package com.example.eventservice.service;

import com.example.eventservice.model.StudentEvent;
import com.example.eventservice.repository.StudentEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentEventService {

    @Autowired
    private StudentEventRepository eventRepository;

    public StudentEvent addEvent(StudentEvent event) {
        return eventRepository.save(event);
    }

    public List<StudentEvent> getEventsByRollNumber(String rollNumber) {
        return eventRepository.findByRollNumber(rollNumber);
    }

    public List<StudentEvent> getAllEvents() {
        return eventRepository.findAll();
    }
}

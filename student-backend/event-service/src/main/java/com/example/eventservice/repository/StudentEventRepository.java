package com.example.eventservice.repository;

import com.example.eventservice.model.StudentEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentEventRepository extends MongoRepository<StudentEvent, String> {
    List<StudentEvent> findByRollNumber(String rollNumber);
}
package com.example.microservice.collection.exception.classes;

public class StudentAlreadyExists extends RuntimeException{

    public StudentAlreadyExists(Integer studentId) {
        super("Student with ID " + studentId + " already exists. If you want to update, attempt a PUT request");
    }

}

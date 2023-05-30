package com.example.microservice.collection.exception.classes;

public class StudentNotFound extends RuntimeException{

    public StudentNotFound(Integer studentId) {
        super("Student with ID " + studentId + " is not found");
    }

}

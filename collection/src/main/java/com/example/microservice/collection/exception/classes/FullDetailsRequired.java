package com.example.microservice.collection.exception.classes;

public class FullDetailsRequired extends RuntimeException {

    public FullDetailsRequired() {
        super("Input validation error. Make sure whether the details are properly defined fully with relevant datatype");
    }

}

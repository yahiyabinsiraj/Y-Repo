package com.example.microservice.collection.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class Student {

    public Integer studentId;
    public String studentName;
    public String department;
    public String section;
    public String academicYear;
    public String semester;

}

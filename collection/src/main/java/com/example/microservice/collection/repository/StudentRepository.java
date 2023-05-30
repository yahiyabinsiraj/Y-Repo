package com.example.microservice.collection.repository;

import com.example.microservice.collection.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {

    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public String deleteStudent(Integer studentId);

    public List<Student> getAllStudents();

    public Student getStudent(Integer studentId);


}

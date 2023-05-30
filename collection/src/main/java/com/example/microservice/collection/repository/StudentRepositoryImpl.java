package com.example.microservice.collection.repository;

import com.example.microservice.collection.exception.classes.FullDetailsRequired;
import com.example.microservice.collection.model.Student;
import com.example.microservice.collection.repository.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentRepositoryImpl implements StudentRepository {

    public Map<Integer, Student> studentDB = new HashMap<>();

    @Override
    public Student addStudent(Student student) throws FullDetailsRequired {

        studentDB.put(student.getStudentId(), student);
        return studentDB.get(student.getStudentId());
    }

    @Override
    public Student updateStudent(Student student) {
        studentDB.replace(student.getStudentId(), student);
        return studentDB.get(student.getStudentId());
    }

    @Override
    public String deleteStudent(Integer studentId) {
        studentDB.remove(studentId);
        return "Student with ID " + studentId + " removed successfully...";
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentDB.values());
    }

    @Override
    public Student getStudent(Integer studentId) {
        return studentDB.get(studentId);
    }
}

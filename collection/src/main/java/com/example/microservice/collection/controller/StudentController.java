package com.example.microservice.collection.controller;

import com.example.microservice.collection.model.Student;
import com.example.microservice.collection.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.updateStudent(student), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Integer studentId) {
        return new ResponseEntity<>(studentService.deleteStudent(studentId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getStudentList() {
        return new ResponseEntity<>(studentService.getStudentList(), HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Object> getStudent(@PathVariable Integer studentId) {
        return new ResponseEntity<>(studentService.getStudent(studentId), HttpStatus.OK);
    }
}

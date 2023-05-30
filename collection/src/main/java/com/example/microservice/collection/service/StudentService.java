package com.example.microservice.collection.service;

import com.example.microservice.collection.exception.classes.FullDetailsRequired;
import com.example.microservice.collection.exception.classes.StudentAlreadyExists;
import com.example.microservice.collection.exception.classes.StudentNotFound;
import com.example.microservice.collection.model.Student;
import com.example.microservice.collection.repository.StudentRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepositoryImpl repository;

    public StudentService(StudentRepositoryImpl repository) {
        this.repository = repository;
    }

    public Student addStudent(Student student) throws FullDetailsRequired, StudentAlreadyExists {
        Optional<Student> studentOptional = Optional.ofNullable(repository.getStudent(student.getStudentId()));
        if(student.getStudentId() == 0
            || student.getStudentName() == null
            || student.getSection() == null
            || student.getDepartment() == null
            || student.getAcademicYear() == null
            || student.getSemester() == null)
            throw new FullDetailsRequired();
        else if(studentOptional.isPresent()) {
            throw new StudentAlreadyExists(student.getStudentId());
        }
        else return repository.addStudent(student);
    }

    public Student updateStudent(Student student) throws FullDetailsRequired, StudentNotFound {
        Optional<Student> studentOptional = Optional.ofNullable(repository.getStudent(student.getStudentId()));
        if(studentOptional.isEmpty())
            throw new StudentNotFound(student.getStudentId());
        else if(student.getStudentId() == 0
                || student.getStudentName() == null
                || student.getSection() == null
                || student.getDepartment() == null
                || student.getAcademicYear() == null
                || student.getSemester() == null)
            throw new FullDetailsRequired();
        else return repository.updateStudent(student);
    }

    public Student getStudent(Integer studentId) throws StudentNotFound {
        Optional<Student> studentOptional = Optional.ofNullable(repository.getStudent(studentId));
        if(studentOptional.isEmpty())
            throw new StudentNotFound(studentId);
        else return repository.getStudent(studentId);
    }

    public List<Student> getStudentList() {
        return repository.getAllStudents();
    }

    public String deleteStudent(Integer studentId) throws StudentNotFound{
        Optional<Student> studentOptional = Optional.ofNullable(repository.getStudent(studentId));
        if(studentOptional.isEmpty())
            throw new StudentNotFound(studentId);
        else return repository.deleteStudent(studentId);

    }

}

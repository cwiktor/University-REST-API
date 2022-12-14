package com.example.demo3.service;

import com.example.demo3.model.Student;
import com.example.demo3.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public void deleteStudent(long id){
        studentRepository.delete(studentRepository.findById(id).orElseThrow());
    }

    public void updateStudent(long id, String name, String lastname){
        studentRepository.findById(id).map(student -> {
            student.setName(name);
            student.setLast_name(lastname);
            return studentRepository.save(student);
        }).orElseThrow();

    }

}

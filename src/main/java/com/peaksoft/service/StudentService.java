package com.peaksoft.service;

import com.peaksoft.models.Student;
import com.peaksoft.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll() {
       return studentRepository.findAll();

    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteByIdStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student findByIdStudent(Long id) {
        studentRepository.findById(id);
        return studentRepository.findById(id).get();
    }


}

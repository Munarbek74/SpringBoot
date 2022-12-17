package com.peaksoft.service;

import com.peaksoft.models.Instructor;
import com.peaksoft.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    public List<Instructor> getAll() {
       return instructorRepository.findAll();

    }

    public void saveInstructor(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    public void deleteByIdInstructor(Long id) {
        instructorRepository.deleteById(id);
    }

    public Instructor findByIdInstructor(Long id) {
        return instructorRepository.findById(id).get();
    }


}

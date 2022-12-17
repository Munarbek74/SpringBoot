package com.peaksoft.service;

import com.peaksoft.models.Company;
import com.peaksoft.models.Course;
import com.peaksoft.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public List<Course> getAll() {
       return courseRepository.findAll();

    }

    public void savecourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteByIdcourse(Long id) {
        courseRepository.deleteById(id);
    }

    public Course findByIdcourse(Long id) {
        return courseRepository.findById(id).get();
    }


}

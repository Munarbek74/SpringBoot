package com.peaksoft.repository;

import com.peaksoft.models.Course;
import com.peaksoft.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
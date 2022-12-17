package com.peaksoft.repository;

import com.peaksoft.models.Instructor;
import com.peaksoft.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
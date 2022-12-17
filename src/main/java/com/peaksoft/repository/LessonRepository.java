package com.peaksoft.repository;

import com.peaksoft.models.Lesson;
import com.peaksoft.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
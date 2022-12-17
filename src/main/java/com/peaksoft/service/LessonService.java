package com.peaksoft.service;

import com.peaksoft.models.Instructor;
import com.peaksoft.models.Lesson;
import com.peaksoft.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }


    public List<Lesson> getAll() {
       return lessonRepository.findAll();

    }

    public void saveLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void deleteByIdLesson(Long id) {
        lessonRepository.deleteById(id);
    }

    public Lesson findByIdLesson(Long id) {
        return lessonRepository.findById(id).get();
    }


}

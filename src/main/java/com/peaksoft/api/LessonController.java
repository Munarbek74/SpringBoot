package com.peaksoft.api;

import com.peaksoft.models.Course;
import com.peaksoft.models.Instructor;
import com.peaksoft.models.Lesson;
import com.peaksoft.service.CourseService;
import com.peaksoft.service.LessonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LessonController {

    private final LessonService lessonService;
    private final CourseService courseService;

    public LessonController(LessonService lessonService, CourseService courseService) {
        this.lessonService = lessonService;
        this.courseService = courseService;
    }


    @GetMapping("/lessons")
    public String getAllInstructors(Model model){
List<Course> courseList = courseService.getAll();
model.addAttribute("courseList", courseList);
        List<Lesson> lessonList = lessonService.getAll();
        model.addAttribute("lessonList", lessonList);


        return "/lesson/lessons";
    }

    @GetMapping("/addLesson")
    public String addLesson(Model model) {
        List<Course> courseList = courseService.getAll();
        model.addAttribute("lesson", new Lesson());
        model.addAttribute("courseList", courseList);

        return "/lesson/addLesson";
    }

    @PostMapping("/saveLesson")
    public String saveLesson(Lesson lesson) {
        lessonService.saveLesson(lesson);
        return "redirect:/lessons";
    }

    @GetMapping("/lesson/edit/{id}")
    public String updateLesson(@PathVariable("id") Long id, Model model) {
        Lesson lesson = lessonService.findByIdLesson(id);
        model.addAttribute("lesson", lesson);
        List<Course> courseList = courseService.getAll();
        model.addAttribute("courseList", courseList);
        return "/lesson/addLesson";
    }

    @GetMapping("/lesson/delete/{id}")
    public String deleteLesson(@PathVariable("id") Long id) {
    lessonService.deleteByIdLesson(id);
    return "redirect:/lessons";
    }


}
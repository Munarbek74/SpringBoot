package com.peaksoft.api;

import com.peaksoft.models.Company;
import com.peaksoft.models.Course;
import com.peaksoft.models.Group;
import com.peaksoft.models.Instructor;
import com.peaksoft.service.CourseService;
import com.peaksoft.service.InstructorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class InstructorController {

    private final InstructorService instructorService;
    private final CourseService courseService;

    public InstructorController(InstructorService instructorService, CourseService courseService) {
        this.instructorService = instructorService;
        this.courseService = courseService;
    }


    @GetMapping("/instructors")
    public String getAllInstructors(Model model){
List<Course> courseList = courseService.getAll();
model.addAttribute("courseList", courseList);
        List<Instructor> instructorList = instructorService.getAll();
        model.addAttribute("instructorList", instructorList);


        return "/instructor/instructors";
    }

    @GetMapping("/addInstructor")
    public String addInstructor(Model model) {
        List<Course> courseList = courseService.getAll();
        model.addAttribute("instructor", new Instructor());
        model.addAttribute("courseList", courseList);

        return "/instructor/addInstructor";
    }

    @PostMapping("/saveInstructor")
    public String saveInstructor(Instructor instructor) {
        instructorService.saveInstructor(instructor);
        return "redirect:/instructors";
    }

    @GetMapping("/instructor/edit/{id}")
    public String updateInstructor(@PathVariable("id") Long id, Model model) {
        Instructor instructor = instructorService.findByIdInstructor(id);
        model.addAttribute("instructor", instructor);
        List<Course> courseList = courseService.getAll();
        model.addAttribute("courseList", courseList);
        return "/instructor/addInstructor";
    }

    @GetMapping("/instructor/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long id) {
    instructorService.deleteByIdInstructor(id);
    return "redirect:/instructors";
    }


}
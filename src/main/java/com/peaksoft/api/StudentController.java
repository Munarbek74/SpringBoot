package com.peaksoft.api;

import com.peaksoft.models.Course;
import com.peaksoft.models.Group;
import com.peaksoft.models.Lesson;
import com.peaksoft.models.Student;
import com.peaksoft.service.GroupService;
import com.peaksoft.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;
    private final GroupService groupService;

    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }


    @GetMapping("/students")
    public String getAllStudents(Model model){
        List<Group> groupList = groupService.getAll();
        model.addAttribute("groupList", groupList);
        List<Student> studentList = studentService.getAll();
        model.addAttribute("studentList", studentList);
        return "/student/students";
    }

    @GetMapping("/addStudent")
    public String addLesson(Model model) {
        List<Group> groupList = groupService.getAll();
        model.addAttribute("student", new Student());
        model.addAttribute("groupList", groupList);

        return "/student/addStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/student/edit/{id}")
    public String updateStudent(@PathVariable("id") Long id, Model model) {
        Student student = studentService.findByIdStudent(id);
        model.addAttribute("student", student);
        List<Group> groupList = groupService.getAll();
        model.addAttribute("groupList", groupList);
        return "/student/addStudent";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteByIdStudent(id);
        return "redirect:/students";
    }


}
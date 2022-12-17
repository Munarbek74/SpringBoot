package com.peaksoft.api;

import com.peaksoft.models.Company;
import com.peaksoft.models.Course;
import com.peaksoft.models.Group;
import com.peaksoft.service.CompanyService;
import com.peaksoft.service.CourseService;
import com.peaksoft.service.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CourseController {

    private final CompanyService companyService;
    private final CourseService courseService;

    private final GroupService groupService;

    public CourseController(CompanyService companyService, CourseService courseService, GroupService groupService) {
        this.companyService = companyService;
        this.courseService = courseService;
        this.groupService = groupService;
    }

    @GetMapping("/courses")
    public String getAllCourses(Model model){
List<Course> courseList = courseService.getAll();
model.addAttribute("courseList", courseList);
        List<Group> groupList = groupService.getAll();
        model.addAttribute("groupList", groupList);
        List<Company> companyList = companyService.getAll();
        model.addAttribute("companyList", companyList);

        return "/course/courses";
    }

    @GetMapping("/addCourse")
    public String addCourse(Model model) {
        List<Company> companyList = companyService.getAll();
        model.addAttribute("course", new Course());
        model.addAttribute("companyList", companyList);

        return "/course/addCourse";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(Course course) {
        courseService.savecourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/course/edit/{id}")
    public String updateCourse(@PathVariable("id") Long id, Model model) {
        Course course = courseService.findByIdcourse(id);
        model.addAttribute("course", course);
        List<Company> companyList = companyService.getAll();
        model.addAttribute("companyList", companyList);
        return "/course/addCourse";
    }

    @GetMapping("/course/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long id) {
    courseService.deleteByIdcourse(id);
    return "redirect:/courses";
    }

    @GetMapping("{courseId}/{companyId}/assignGroup")
    private String assignGroup(@PathVariable("companyId") Long comId,
                               @PathVariable("courseId") Long courseId,
                               @ModelAttribute("group") Group group) {
        groupService.assignGroup(courseId, group.getId());
        return "redirect:/courses/" + comId;
    }
}
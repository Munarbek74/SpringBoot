package com.peaksoft.api;

import com.peaksoft.models.Company;
import com.peaksoft.models.Course;
import com.peaksoft.models.Group;
import com.peaksoft.service.CompanyService;
import com.peaksoft.service.CourseService;
import com.peaksoft.service.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GroupController {

    private final CourseService courseService;

    private final GroupService groupService;
    private final CompanyService companyService;

    public GroupController(CourseService courseService, GroupService groupService, CompanyService companyService) {
        this.courseService = courseService;
        this.groupService = groupService;
        this.companyService = companyService;
    }

    @GetMapping("/groups")
    public String getAllGroup(Model model){
List<Group> groupList = groupService.getAll();
model.addAttribute("groupList", groupList);
        return "/group/groups";
    }

    @GetMapping("/addGroup")
    public String addGroup(Model model) {
        List<Company> companyList = companyService.getAll();
        List<Course> courseList = courseService.getAll();
        model.addAttribute("group", new Group());
        model.addAttribute("companyList", companyList);
        model.addAttribute("courseList", courseList);

        return "/group/addGroup";
    }

    @PostMapping("/saveGroup")
    public String saveGroup(Group group) {
        groupService.savegroup(group);

        return "redirect:/groups";
    }

    @GetMapping("/group/edit/{id}")
    public String updateGroup(@PathVariable("id") Long id, Model model) {
        Group group = groupService.findByIdgroup(id);
        model.addAttribute("group", group);
        List<Company> companyList = companyService.getAll();
        model.addAttribute("companyList", companyList);
        List<Course> courseList = courseService.getAll();
        model.addAttribute("courseList", courseList);
        return "/group/addGroup";
    }

    @GetMapping("/group/delete/{id}")
    public String deleteGroup(@PathVariable("id") Long id) {
    groupService.deleteByIdgroup(id);
    return "redirect:/groups";
    }


}
package com.peaksoft.api;

import com.peaksoft.models.Course;
import com.peaksoft.models.Lesson;
import com.peaksoft.models.Task;
import com.peaksoft.service.CourseService;
import com.peaksoft.service.LessonService;
import com.peaksoft.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TaskController {

    private final LessonService lessonService;
    private final TaskService taskService;

    public TaskController(LessonService lessonService,  TaskService taskService) {
        this.lessonService = lessonService;
        this.taskService = taskService;

    }


    @GetMapping("/tasks")
    public String getAllTasks(Model model){
List<Task> taskList = taskService.getAll();
model.addAttribute("taskList", taskList);
        List<Lesson> lessonList = lessonService.getAll();
        model.addAttribute("lessonList", lessonList);
        return "/task/tasks";
    }

    @GetMapping("/addTask")
    public String addTask(Model model) {
        List<Lesson> lessonList = lessonService.getAll();
        model.addAttribute("task", new Task());
        model.addAttribute("lessonList", lessonList);

        return "/task/addTask";
    }

    @PostMapping("/saveTask")
    public String saveTask(Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/task/edit/{id}")
    public String updateTask(@PathVariable("id") Long id, Model model) {
        Task task = taskService.findByIdTask(id);
        model.addAttribute("task", task);
        List<Lesson> lessonList = lessonService.getAll();
        model.addAttribute("lessonList", lessonList);
        return "/task/addTask";
    }

    @GetMapping("/task/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
    taskService.deleteByIdTask(id);
    return "redirect:/tasks";
    }


}
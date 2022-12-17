package com.peaksoft.service;

import com.peaksoft.models.Student;
import com.peaksoft.models.Task;
import com.peaksoft.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getAll() {
       return taskRepository.findAll();

    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteByIdTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task findByIdTask(Long id) {
        taskRepository.findById(id);
        return taskRepository.findById(id).get();
    }


}

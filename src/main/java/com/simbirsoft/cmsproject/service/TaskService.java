package com.simbirsoft.cmsproject.service;

import com.simbirsoft.cmsproject.dto.TaskDto;
import com.simbirsoft.cmsproject.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    List<Task> getAll();

    Task createTask(TaskDto taskDto);

    Task updateTask(Long id, TaskDto taskDto);

    Task getTask(Long id);

    void deleteTask(Long id);
}
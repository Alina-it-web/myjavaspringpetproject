package com.simbirsoft.cmsproject.service.impl;

import com.simbirsoft.cmsproject.dto.TaskDto;
import com.simbirsoft.cmsproject.entity.Task;
import com.simbirsoft.cmsproject.facade.TaskFacade;
import com.simbirsoft.cmsproject.repository.TaskRepository;
import com.simbirsoft.cmsproject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskFacade taskFacade;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    @Transactional
    public Task createTask(TaskDto taskDto) {
        return taskRepository.save(taskFacade.taskDtoToProj(taskDto));
    }

    @Override
    @Transactional
    public Task updateTask(Long id, TaskDto taskDto) {
        Task existingTask = taskRepository.getReferenceById(id);

        existingTask.setName(taskDto.getName());
        existingTask.setDescription(taskDto.getDescription());
        existingTask.setTaskStatus(taskDto.getTaskStatus());
        existingTask.setIdUserCreator(taskDto.getIdUserCreator());
        existingTask.setIdUserPerformer(taskDto.getIdUserPerformer());
        existingTask.setIdUserPerformer(taskDto.getIdUserPerformer());

        existingTask = taskRepository.save(existingTask);

        return existingTask;
    }

    @Override
    public Task getTask(Long id) {
        Task curentTask = taskRepository.getReferenceById(id);
        return curentTask;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}

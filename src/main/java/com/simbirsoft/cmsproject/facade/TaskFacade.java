package com.simbirsoft.cmsproject.facade;

import org.springframework.stereotype.Component;
import com.simbirsoft.cmsproject.dto.TaskDto;
import com.simbirsoft.cmsproject.entity.Task;

@Component
public class TaskFacade {
    public TaskDto taskToTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setName(task.getName());
        taskDto.setDescription(task.getDescription());
        taskDto.setTaskStatus(task.getTaskStatus());
        taskDto.setIdUserCreator(task.getIdUserCreator());
        taskDto.setIdUserPerformer(task.getIdUserPerformer());
//        taskDto.setcreatedDate(task.getCreatedDate());

        return taskDto;
    }

    public Task taskDtoToProj(TaskDto taskDto){
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setTaskStatus(taskDto.getTaskStatus());
        task.setIdUserCreator(taskDto.getIdUserCreator());
        task.setIdUserPerformer(taskDto.getIdUserPerformer());

        return task;
    }
}

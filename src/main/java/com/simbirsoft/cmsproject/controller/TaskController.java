package com.simbirsoft.cmsproject.controller;

import com.simbirsoft.cmsproject.dto.TaskDto;
import com.simbirsoft.cmsproject.entity.Task;
import com.simbirsoft.cmsproject.facade.TaskFacade;
import com.simbirsoft.cmsproject.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/task")
@Tag(
        name = "Task",
        description = "All methods for working with task"
)
public class TaskController {
    @Autowired
    TaskService taskService;

    @Autowired
    TaskFacade taskFacade;

    @GetMapping("/all")
    @Operation(summary = "Get a list of all tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        List<TaskDto> postDTOList = taskService.getAll()
                .stream()
                .map(taskFacade::taskToTaskDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(postDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get information about the task by its id")
    public ResponseEntity<Object> getTask(
            @PathVariable Long id
    ){
        Task task = taskService.getTask(id);
        TaskDto taskDtoResponse = taskFacade.taskToTaskDto(task);
        return new ResponseEntity<>(taskDtoResponse, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create the task")
    public ResponseEntity<Object> createTask(
            @Valid @RequestBody TaskDto taskDto) {
        Task task = taskService.createTask(taskDto);
        TaskDto taskDtoResponse = taskFacade.taskToTaskDto(task);
        return new ResponseEntity<>(taskDtoResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update information about the task by its id")
    public ResponseEntity<Object> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskDto taskDto
    ){
        Task task = taskService.updateTask(id, taskDto);
        TaskDto taskDtoResponse = taskFacade.taskToTaskDto(task);
        return new ResponseEntity<>(taskDtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete the task by its id")
    public ResponseEntity<Object> updateTask(
            @PathVariable Long id
    ){
        taskService.deleteTask(id);
        return new ResponseEntity<>("task was deleted", HttpStatus.OK);
    }

}

package com.simbirsoft.cmsproject.controller;

import com.simbirsoft.cmsproject.dto.ProjectDto;
import com.simbirsoft.cmsproject.entity.Project;
import com.simbirsoft.cmsproject.facade.ProjectFacade;
import com.simbirsoft.cmsproject.service.ProjectService;
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
@RequestMapping("api/project")
@Tag(
        name = "Project",
        description = "All methods for working with project "
)
public class ProjectController {
    @Autowired
    private ProjectFacade projectFacade;
    @Autowired
    protected ProjectService projectService;

    @GetMapping("/all")
    @Operation(summary = "Get a list of all project")
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        List<ProjectDto> postDTOList = projectService.getAll()
                .stream()
                .map(projectFacade::projectToProjectDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(postDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get information about the project by its id")
    public ResponseEntity<Object> getProject(
            @PathVariable Long id
    ){
        Project project = projectService.getProject(id);
        ProjectDto projectDtoResponse = projectFacade.projectToProjectDto(project);
        return new ResponseEntity<>(projectDtoResponse, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create the project")
    public ResponseEntity<Object> createProject(
            @Valid @RequestBody ProjectDto projectDto) {
        Project project = projectService.createProject(projectDto);
        ProjectDto projectDtoResponse = projectFacade.projectToProjectDto(project);
        return new ResponseEntity<>(projectDtoResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update information about the project by its id")
    public ResponseEntity<Object> updateProject(
            @PathVariable Long id,
            @Valid @RequestBody ProjectDto projectDto
    ){
        Project project = projectService.updateProject(id, projectDto);
        ProjectDto projectDtoResponse = projectFacade.projectToProjectDto(project);
        return new ResponseEntity<>(projectDtoResponse, HttpStatus.OK);
    }
}


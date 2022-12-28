package com.simbirsoft.cmsproject.facade;

import org.springframework.stereotype.Component;
import com.simbirsoft.cmsproject.dto.ProjectDto;
import com.simbirsoft.cmsproject.entity.Project;

@Component
public class ProjectFacade {
    public ProjectDto projectToProjectDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setName(project.getName());
        projectDto.setDescription(project.getDescription());
        projectDto.setProjectStatus(project.getProjectStatus());
        projectDto.setIdUserCreator(project.getIdUserCreator());
        projectDto.setIdUserPerformer(project.getIdUserPerformer());
        projectDto.setCreatedDate(project.getCreatedDate());

        return projectDto;
    }

    public Project projectDtoToProj(ProjectDto projectDto){
        Project project = new Project();
        project.setId(projectDto.getId());
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setProjectStatus(projectDto.getProjectStatus());
        project.setIdUserCreator(projectDto.getIdUserCreator());
        return project;
    }
}

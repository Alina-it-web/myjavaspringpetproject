package com.simbirsoft.cmsproject.service;

import com.simbirsoft.cmsproject.dto.ProjectDto;
import com.simbirsoft.cmsproject.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    List<Project> getAll();

    Project createProject(ProjectDto projectDto);

    Project updateProject(Long id, ProjectDto projectDto);

    Project getProject(Long id);
}
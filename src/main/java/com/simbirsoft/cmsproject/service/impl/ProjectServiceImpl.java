package com.simbirsoft.cmsproject.service.impl;

import com.simbirsoft.cmsproject.dto.ProjectDto;
import com.simbirsoft.cmsproject.entity.Project;
import com.simbirsoft.cmsproject.exception.ProjectNotFoundException;
import com.simbirsoft.cmsproject.facade.ProjectFacade;
import com.simbirsoft.cmsproject.repository.ProjectRepository;
import com.simbirsoft.cmsproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectFacade projectFacade;

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    @Transactional
    public Project createProject(ProjectDto projectDto) {
        return projectRepository.save(projectFacade.projectDtoToProj(projectDto));
    }

    @Override
    @Transactional
    public Project updateProject(Long id, ProjectDto projectDto) {
        Project existingProject = projectRepository.getReferenceById(id);

        existingProject.setName(projectDto.getName());
        existingProject.setDescription(projectDto.getDescription());
        existingProject.setProjectStatus(projectDto.getProjectStatus());
        existingProject.setIdUserCreator(projectDto.getIdUserCreator());
        existingProject.setIdUserPerformer(projectDto.getIdUserPerformer());

        existingProject = projectRepository.save(existingProject);

        return existingProject;
    }

    @Override
    public Project getProject(Long id) {
//            try {
//                Project curentProject = projectRepository.getReferenceById(id);
//                return curentProject;
//            } catch (Exception e){
//               throw new ProjectNotFoundException("Post cannot be found for username: " );
//            }


//                Project curentProject = projectRepository.getReferenceById(id).orElseThrow(() -> new ProjectNotFoundException("Project cannot be found " ));;
                Project curentProject = projectRepository.getReferenceById(id);
                return curentProject;


    }

}

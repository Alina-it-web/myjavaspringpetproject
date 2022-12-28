package com.simbirsoft.cmsproject.repository;

import com.simbirsoft.cmsproject.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}

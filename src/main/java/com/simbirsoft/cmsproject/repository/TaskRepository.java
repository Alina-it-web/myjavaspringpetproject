package com.simbirsoft.cmsproject.repository;

import com.simbirsoft.cmsproject.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
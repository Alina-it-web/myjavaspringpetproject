package com.simbirsoft.cmsproject.dto;

import com.simbirsoft.cmsproject.entity.enums.TaskStatusEnum;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TaskDto {
    private Long id;
    @NotEmpty
    private String name;
    private String description;
    private TaskStatusEnum taskStatus;
    private Long idUserCreator;
    private Long idUserPerformer;
    private Long idRelease;
}

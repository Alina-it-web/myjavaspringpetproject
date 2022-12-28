package com.simbirsoft.cmsproject.dto;

import com.simbirsoft.cmsproject.entity.enums.ProjectStatusEnum;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class ProjectDto {
    private Long id;
    @NotEmpty
    private String name;
    private String description;
    private ProjectStatusEnum projectStatus;
    private Long idUserCreator;
    private Long idUserPerformer;
    private LocalDateTime createdDate;
}

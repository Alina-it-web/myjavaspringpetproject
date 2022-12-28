package com.simbirsoft.cmsproject.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
@Data

public class ReleaseDto {
    private Long id;
    @NotEmpty
    private String name;

    private LocalDateTime beginDate;
    private LocalDateTime endDate;

}

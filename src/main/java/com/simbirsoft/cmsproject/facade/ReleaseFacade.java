package com.simbirsoft.cmsproject.facade;

import org.springframework.stereotype.Component;
import com.simbirsoft.cmsproject.dto.ReleaseDto;
import com.simbirsoft.cmsproject.entity.Release;

@Component

public class ReleaseFacade {
    public ReleaseDto releaseToReleaseDto(Release release) {
        ReleaseDto releaseDto = new ReleaseDto();
        releaseDto.setId(release.getId());
        releaseDto.setName(release.getName());
        releaseDto.setBeginDate(release.getBeginDate());
        releaseDto.setEndDate(release.getEndDate());

        return releaseDto;
    }

    public Release releaseDtoToProj(ReleaseDto releaseDto){
        Release release = new Release();
        release.setId(releaseDto.getId());
        release.setName(releaseDto.getName());
        release.setBeginDate(releaseDto.getBeginDate());
        release.setEndDate(releaseDto.getEndDate());

        return release;
    }
}

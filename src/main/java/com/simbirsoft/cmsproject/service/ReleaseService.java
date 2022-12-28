package com.simbirsoft.cmsproject.service;

import com.simbirsoft.cmsproject.dto.ReleaseDto;
import com.simbirsoft.cmsproject.entity.Release;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReleaseService {
    List<Release> getAll();

    Release createRelease(ReleaseDto releaseDto);

    Release updateRelease(Long id, ReleaseDto releaseDto);

    Release getRelease(Long id);

    void deleteRelease(Long id);
}
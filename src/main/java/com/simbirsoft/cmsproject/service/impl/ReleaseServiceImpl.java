package com.simbirsoft.cmsproject.service.impl;

import com.simbirsoft.cmsproject.dto.ReleaseDto;
import com.simbirsoft.cmsproject.entity.Release;
import com.simbirsoft.cmsproject.facade.ReleaseFacade;
import com.simbirsoft.cmsproject.repository.ReleaseRepository;
import com.simbirsoft.cmsproject.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ReleaseServiceImpl implements ReleaseService {
    @Autowired
    private ReleaseRepository releaseRepository;

    @Autowired
    private ReleaseFacade releaseFacade;

    @Override
    public List<Release> getAll() {
        return releaseRepository.findAll();
    }

    @Override
    @Transactional
    public Release createRelease(ReleaseDto releaseDto) {
        return releaseRepository.save(releaseFacade.releaseDtoToProj(releaseDto));
    }

    @Override
    @Transactional
    public Release updateRelease(Long id, ReleaseDto releaseDto) {
        Release existingRelease = releaseRepository.getReferenceById(id);

        existingRelease.setName(releaseDto.getName());
        existingRelease.setBeginDate(releaseDto.getBeginDate());
        existingRelease.setEndDate(releaseDto.getEndDate());

        existingRelease = releaseRepository.save(existingRelease);

        return existingRelease;
    }

    @Override
    public Release getRelease(Long id) {
        Release curentRelease = releaseRepository.getReferenceById(id);
        return curentRelease;
    }

    @Override
    public void deleteRelease(Long id) {
        releaseRepository.deleteById(id);
    }

}

package com.simbirsoft.cmsproject.repository;

import com.simbirsoft.cmsproject.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends JpaRepository<Release, Long> {

}

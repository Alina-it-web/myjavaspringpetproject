package com.simbirsoft.cmsproject.controller;

import com.simbirsoft.cmsproject.dto.ReleaseDto;
import com.simbirsoft.cmsproject.entity.Release;
import com.simbirsoft.cmsproject.facade.ReleaseFacade;
import com.simbirsoft.cmsproject.service.ReleaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/release")
@Tag(
        name = "Release",
        description = "All methods for working with project releases"
)
public class ReleaseController {
    @Autowired
    ReleaseService releaseService;

    @Autowired
    ReleaseFacade releaseFacade;

    @GetMapping("/all")
    @Operation(summary = "Get a list of all releases")
    public ResponseEntity<List<ReleaseDto>> getAllReleases() {
        List<ReleaseDto> postDTOList = releaseService.getAll()
                .stream()
                .map(releaseFacade::releaseToReleaseDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(postDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get information about the release by its id")
    public ResponseEntity<Object> getRelease(
            @PathVariable Long id
    ){
        Release release = releaseService.getRelease(id);
        ReleaseDto releaseDtoResponse = releaseFacade.releaseToReleaseDto(release);
        return new ResponseEntity<>(releaseDtoResponse, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create the release")
    public ResponseEntity<Object> createRelease(
            @Valid @RequestBody ReleaseDto releaseDto) {
        Release release = releaseService.createRelease(releaseDto);
        ReleaseDto releaseDtoResponse = releaseFacade.releaseToReleaseDto(release);
        return new ResponseEntity<>(releaseDtoResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update information about the release by its id")
    public ResponseEntity<Object> updateRelease(
            @PathVariable Long id,
            @Valid @RequestBody ReleaseDto releaseDto
    ){
        Release release = releaseService.updateRelease(id, releaseDto);
        ReleaseDto releaseDtoResponse = releaseFacade.releaseToReleaseDto(release);
        return new ResponseEntity<>(releaseDtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete the release by its id")
    public ResponseEntity<Object> updateRelease(
            @PathVariable Long id
    ){
        releaseService.deleteRelease(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}

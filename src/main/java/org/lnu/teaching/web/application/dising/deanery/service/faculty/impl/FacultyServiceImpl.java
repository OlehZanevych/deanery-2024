package org.lnu.teaching.web.application.dising.deanery.service.faculty.impl;

import lombok.AllArgsConstructor;
import org.lnu.teaching.web.application.dising.deanery.annotation.TrackExecution;
import org.lnu.teaching.web.application.dising.deanery.dto.common.ValueDto;
import org.lnu.teaching.web.application.dising.deanery.dto.faculty.BaseFacultyDto;
import org.lnu.teaching.web.application.dising.deanery.dto.faculty.FacultyDto;
import org.lnu.teaching.web.application.dising.deanery.dto.faculty.FacultyPatch;
import org.lnu.teaching.web.application.dising.deanery.dto.faculty.query.params.FacultyFilterOptions;
import org.lnu.teaching.web.application.dising.deanery.entity.faculty.FacultyEntity;
import org.lnu.teaching.web.application.dising.deanery.exception.BadRequestException;
import org.lnu.teaching.web.application.dising.deanery.mapper.FacultyMapper;
import org.lnu.teaching.web.application.dising.deanery.repository.faculty.FacultyRepository;
import org.lnu.teaching.web.application.dising.deanery.service.faculty.FacultyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@TrackExecution
@AllArgsConstructor
public class FacultyServiceImpl implements FacultyService {
    
    private final FacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;

    @Override
    public FacultyDto create(BaseFacultyDto facultyDto) {
        FacultyEntity facultyEntity = facultyMapper.toEntity(facultyDto);
        FacultyEntity createFacultyEntity = facultyRepository.create(facultyEntity);
        return facultyMapper.toDto(createFacultyEntity);
    }
    
    @Override
    public List<FacultyDto> findAll(FacultyFilterOptions filterOptions, Integer limit, Integer offset) {
        List<FacultyEntity> facultyEntities = facultyRepository.findAll(filterOptions, limit, offset);
        return facultyMapper.toDtoList(facultyEntities);
    }

    @Override
    public ValueDto<Integer> count(FacultyFilterOptions filterOptions) {
        int count = facultyRepository.count(filterOptions);
        return new ValueDto<>(count);
    }

    @Override
    public FacultyDto find(Long id) {
        FacultyEntity facultyEntity = facultyRepository.find(id);
        return facultyMapper.toDto(facultyEntity);
    }

    @Override
    public void update(Long id, BaseFacultyDto facultyDto) {
        FacultyEntity facultyEntity = facultyMapper.toEntity(facultyDto);
        facultyEntity.setId(id);

        facultyRepository.update(facultyEntity);
    }

    @Override
    public void patch(Long id, FacultyPatch facultyPatch) {
        if (facultyPatch.isEmpty()) {
            throw new BadRequestException("Faculty patch is empty!");
        }

        facultyRepository.patch(id, facultyPatch);
    }

    @Override
    public void delete(Long id) {
        facultyRepository.delete(id);
    }
}

package org.lnu.teaching.web.application.dising.deanery.service.faculty.impl;

import lombok.AllArgsConstructor;
import org.lnu.teaching.web.application.dising.deanery.dto.faculty.BaseFacultyDto;
import org.lnu.teaching.web.application.dising.deanery.dto.faculty.FacultyDto;
import org.lnu.teaching.web.application.dising.deanery.entity.faculty.FacultyEntity;
import org.lnu.teaching.web.application.dising.deanery.mapper.FacultyMapper;
import org.lnu.teaching.web.application.dising.deanery.repository.faculty.FacultyRepository;
import org.lnu.teaching.web.application.dising.deanery.service.faculty.FacultyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public List<FacultyDto> findAll() {
        List<FacultyEntity> facultyEntities = facultyRepository.findAll();
        return facultyMapper.toDtoList(facultyEntities);
    }

    @Override
    public FacultyDto find(Long id) {
        FacultyEntity facultyEntity = facultyRepository.find(id);
        return facultyMapper.toDto(facultyEntity);
    }
}

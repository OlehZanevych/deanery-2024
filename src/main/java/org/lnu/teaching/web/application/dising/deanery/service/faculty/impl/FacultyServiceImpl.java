package org.lnu.teaching.web.application.dising.deanery.service.faculty.impl;

import lombok.AllArgsConstructor;
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
    public List<FacultyDto> findAll() {
        List<FacultyEntity> facultyEntities = facultyRepository.findAll();
        return facultyMapper.toDtoList(facultyEntities);
    }

    @Override
    public FacultyDto find(Long id) {
        FacultyDto faculty = new FacultyDto();
        faculty.setId(id);

        return faculty;
    }
}

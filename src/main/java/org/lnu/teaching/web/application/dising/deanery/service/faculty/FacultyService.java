package org.lnu.teaching.web.application.dising.deanery.service.faculty;

import org.lnu.teaching.web.application.dising.deanery.dto.faculty.FacultyDto;

import java.util.List;

public interface FacultyService {
    List<FacultyDto> findAll();
    FacultyDto find(Long id);
}

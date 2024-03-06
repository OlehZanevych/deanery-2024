package org.lnu.teaching.web.application.dising.deanery.service.faculty;

import org.lnu.teaching.web.application.dising.deanery.dto.common.ValueDto;
import org.lnu.teaching.web.application.dising.deanery.dto.faculty.BaseFacultyDto;
import org.lnu.teaching.web.application.dising.deanery.dto.faculty.FacultyDto;
import org.lnu.teaching.web.application.dising.deanery.dto.faculty.FacultyPatch;
import org.lnu.teaching.web.application.dising.deanery.dto.faculty.query.params.FacultyFilterOptions;

import java.util.List;

public interface FacultyService {
    FacultyDto create(BaseFacultyDto facultyDto);
    List<FacultyDto> findAll(FacultyFilterOptions filterOptions, Integer limit, Integer offset);
    ValueDto<Integer> count(FacultyFilterOptions filterOptions);
    FacultyDto find(Long id);
    void update(Long id, BaseFacultyDto facultyDto);
    void patch(Long id, FacultyPatch facultyPatch);
    void delete(Long id);
}

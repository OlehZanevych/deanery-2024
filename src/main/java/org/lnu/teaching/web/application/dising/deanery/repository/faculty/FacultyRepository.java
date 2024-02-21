package org.lnu.teaching.web.application.dising.deanery.repository.faculty;

import org.lnu.teaching.web.application.dising.deanery.entity.faculty.FacultyEntity;

import java.util.List;

public interface FacultyRepository {
    List<FacultyEntity> findAll();
}

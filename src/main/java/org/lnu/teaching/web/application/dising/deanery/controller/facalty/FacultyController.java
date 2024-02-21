package org.lnu.teaching.web.application.dising.deanery.controller.facalty;

import lombok.AllArgsConstructor;
import org.lnu.teaching.web.application.dising.deanery.dto.faculty.FacultyDto;
import org.lnu.teaching.web.application.dising.deanery.service.faculty.FacultyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("faculties")
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping
    public List<FacultyDto> findAll() {
        return facultyService.findAll();
    }


    @GetMapping("{id}")
    public FacultyDto find(@PathVariable Long id) {
        return facultyService.find(id);
    }
}

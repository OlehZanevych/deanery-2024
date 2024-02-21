package org.lnu.teaching.web.application.dising.deanery.repository.faculty.impl;

import lombok.AllArgsConstructor;
import org.lnu.teaching.web.application.dising.deanery.entity.faculty.FacultyEntity;
import org.lnu.teaching.web.application.dising.deanery.repository.faculty.FacultyRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class FacultyRepositoryImpl implements FacultyRepository {

    private static final String SELECT_FACULTIES_QUERY = """
            SELECT
                id,
                name,
                website,
                email,
                phone,
                address,
                info
            FROM faculties
            """;

    private static final RowMapper<FacultyEntity> FACULTY_ROW_MAPPER = (rs, rowNum) -> {
        FacultyEntity entity = new FacultyEntity();

        entity.setId(rs.getObject("id", Long.class));
        entity.setName(rs.getString("name"));
        entity.setWebsite(rs.getString("website"));
        entity.setEmail(rs.getString("email"));
        entity.setPhone(rs.getString("phone"));
        entity.setAddress(rs.getString("address"));
        entity.setInfo(rs.getString("info"));

        return entity;
    };


    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<FacultyEntity> findAll() {
        return jdbcTemplate.query(SELECT_FACULTIES_QUERY, FACULTY_ROW_MAPPER);
    }
}

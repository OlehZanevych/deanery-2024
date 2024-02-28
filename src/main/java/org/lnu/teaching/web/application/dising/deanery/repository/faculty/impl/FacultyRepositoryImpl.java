package org.lnu.teaching.web.application.dising.deanery.repository.faculty.impl;

import lombok.AllArgsConstructor;
import org.lnu.teaching.web.application.dising.deanery.exception.DataConflictException;
import org.lnu.teaching.web.application.dising.deanery.exception.NotFoundException;
import org.lnu.teaching.web.application.dising.deanery.entity.faculty.FacultyEntity;
import org.lnu.teaching.web.application.dising.deanery.repository.faculty.FacultyRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class FacultyRepositoryImpl implements FacultyRepository {

    private static final String INSERT_FACULTY_QUERY = """
            INSERT INTO faculties (
                name,
                website,
                email,
                phone,
                address,
                info
            ) VALUES (
                :name,
                :website,
                :email,
                :phone,
                :address,
                :info
            )
            """;

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

    private static final String SELECT_FACULTY_BY_ID_QUERY = """
            SELECT
                id,
                name,
                website,
                email,
                phone,
                address,
                info
            FROM faculties
            WHERE id = :id
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
    public FacultyEntity create(FacultyEntity facultyEntity) {
        SqlParameterSource sqlParameters = new MapSqlParameterSource()
                .addValue("name", facultyEntity.getName())
                .addValue("website", facultyEntity.getWebsite())
                .addValue("email", facultyEntity.getEmail())
                .addValue("phone", facultyEntity.getPhone())
                .addValue("address", facultyEntity.getAddress())
                .addValue("info", facultyEntity.getInfo());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        try {
            jdbcTemplate.update(INSERT_FACULTY_QUERY, sqlParameters, keyHolder);
        } catch (DuplicateKeyException e) {
            if (e.getCause().getMessage().contains("duplicate key value violates unique constraint \"faculties_name_key\"")) {
                throw new DataConflictException(String.format("Faculty with name \"%s\" already exists!", facultyEntity.getName()));
            }

            throw e;
        }

        Long id = (Long) keyHolder.getKeys().get("id");
        facultyEntity.setId(id);

        return facultyEntity;
    }

    @Override
    public List<FacultyEntity> findAll() {
        return jdbcTemplate.query(SELECT_FACULTIES_QUERY, FACULTY_ROW_MAPPER);
    }

    @Override
    public FacultyEntity find(Long id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_FACULTY_BY_ID_QUERY, new MapSqlParameterSource("id", id), FACULTY_ROW_MAPPER);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Faculty with id " + id + " not found!");
        }
    }
}

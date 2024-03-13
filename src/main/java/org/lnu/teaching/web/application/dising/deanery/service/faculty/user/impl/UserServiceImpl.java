package org.lnu.teaching.web.application.dising.deanery.service.faculty.user.impl;

import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.lnu.teaching.web.application.dising.deanery.dto.user.UserCreateDto;
import org.lnu.teaching.web.application.dising.deanery.dto.user.UserDto;
import org.lnu.teaching.web.application.dising.deanery.entity.user.UserEntity;
import org.lnu.teaching.web.application.dising.deanery.exception.DataConflictException;
import org.lnu.teaching.web.application.dising.deanery.mapper.UserMapper;
import org.lnu.teaching.web.application.dising.deanery.repository.user.UserRepository;
import org.lnu.teaching.web.application.dising.deanery.service.faculty.user.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto create (UserCreateDto userDto) {
        UserEntity userEntity = userMapper.toEntity(userDto);

        String passwordHash = bCryptPasswordEncoder.encode(userDto.getPassword());
        userEntity.setPasswordHash(passwordHash);

        try {
            userEntity = userRepository.save(userEntity);
        } catch (RuntimeException e) {
            Throwable cause = e.getCause();
            if (cause instanceof ConstraintViolationException
                    && "users_username_key".equals(((ConstraintViolationException) cause).getConstraintName())) {

                String errorMessage = String.format("Username %s is already used!", userEntity.getUsername());
                throw new DataConflictException(errorMessage);
            }

            throw e;
        }
        
        return userMapper.toDto(userEntity);
    }
}

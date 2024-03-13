package org.lnu.teaching.web.application.dising.deanery.mapper;

import org.lnu.teaching.web.application.dising.deanery.dto.user.UserCreateDto;
import org.lnu.teaching.web.application.dising.deanery.dto.user.UserDto;
import org.lnu.teaching.web.application.dising.deanery.entity.user.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserCreateDto userDto);
    UserDto toDto(UserEntity userEntity);
    List<UserDto> toList(List<UserEntity> userEntities);
}

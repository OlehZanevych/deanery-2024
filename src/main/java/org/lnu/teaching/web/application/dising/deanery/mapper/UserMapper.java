package org.lnu.teaching.web.application.dising.deanery.mapper;

import org.lnu.teaching.web.application.dising.deanery.dto.user.UserCreateDto;
import org.lnu.teaching.web.application.dising.deanery.dto.user.UserDto;
import org.lnu.teaching.web.application.dising.deanery.dto.user.UserUpdateDto;
import org.lnu.teaching.web.application.dising.deanery.entity.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserCreateDto userDto);
    UserEntity toEntity(UserUpdateDto userDto);
    UserDto toDto(UserEntity userEntity);
    List<UserDto> toDtoList(List<UserEntity> userEntities);
    void update(@MappingTarget UserEntity userEntity, UserUpdateDto userDto);
}

package org.lnu.teaching.web.application.dising.deanery.service.faculty.user;

import org.lnu.teaching.web.application.dising.deanery.dto.user.UserCreateDto;
import org.lnu.teaching.web.application.dising.deanery.dto.user.UserDto;

public interface UserService {
    UserDto create (UserCreateDto userDto);
}

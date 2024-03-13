package org.lnu.teaching.web.application.dising.deanery.controller.user;

import lombok.AllArgsConstructor;
import org.lnu.teaching.web.application.dising.deanery.dto.user.UserCreateDto;
import org.lnu.teaching.web.application.dising.deanery.dto.user.UserDto;
import org.lnu.teaching.web.application.dising.deanery.service.faculty.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody UserCreateDto userDto) {
        return userService.create(userDto);
    }
}

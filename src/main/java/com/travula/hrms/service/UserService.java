package com.travula.hrms.service;

import com.travula.hrms.dto.UserDto;
import com.travula.hrms.entity.User;

public interface UserService {
    User add(UserDto userDto);

    UserDto getUserDto(User user);

    Boolean isEmailExist(String email);
}

package com.travula.hrms.service;

import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.dto.UserDto;
import com.travula.hrms.entity.User;

public interface UserService {
    User add(UserDto userDto);

    UserDto getUserDto(User user);

    Boolean isEmailExist(String email);

    Result enableEmail(String email,int verificationCode);
}

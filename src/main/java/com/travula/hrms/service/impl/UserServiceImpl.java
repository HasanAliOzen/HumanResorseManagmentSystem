package com.travula.hrms.service.impl;

import com.travula.hrms.dto.UserDto;
import com.travula.hrms.entity.User;
import com.travula.hrms.repo.UserRepository;
import com.travula.hrms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User add(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        this.userRepository.save(user);
        return user;
    }

    @Override
    public UserDto getUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

    @Override
    public Boolean isEmailExist(String email) {
        if(this.userRepository.existsUserByEmail(email)){
            return true;
        }else{
            return false;
        }
    }


}

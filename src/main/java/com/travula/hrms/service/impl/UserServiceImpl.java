package com.travula.hrms.service.impl;

import com.travula.hrms.core.utilities.results.ErrorResult;
import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.core.utilities.results.SuccessResult;
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
        user.setEmailEnabled(false);
        user.setVerificationCode((int) Math.floor(Math.random()*100000));
        this.userRepository.save(user);
        return user;
    }

    @Override
    public UserDto getUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setEmailEnabled(user.isEmailEnabled());
        userDto.setVerificationCode(user.getVerificationCode());

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

    @Override
    public Result enableEmail(String email,int verificationCode) {
        User user = this.userRepository.getUserByEmail(email);
        int usersCode =user.getVerificationCode();
        if (verificationCode == usersCode){
            user.setEmailEnabled(true);
            this.userRepository.save(user);
            return new SuccessResult("Email verified successfully!!!");
        }else {
            return new ErrorResult("Email cannot verified!!! Wrong verification code!!!");
        }
    }
}

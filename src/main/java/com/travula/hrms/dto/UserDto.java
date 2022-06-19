package com.travula.hrms.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDto {
    private Long id;

    private String email;

    private String password;

    private boolean isEmailEnabled;

    private int verificationCode;
}

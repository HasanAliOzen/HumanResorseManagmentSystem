package com.travula.hrms.dto;

import lombok.Data;

@Data
public class EmployerDto {
    private Long id;

    private String companyName;

    private String webPage;

    private String phoneNumber;

    private boolean isEnabled;

    private UserDto userDto;
}

package com.travula.hrms.dto;

import com.travula.hrms.entity.User;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class EmployerDto {
    private Long id;

    private String companyName;

    private String webPage;

    private String phoneNumber;

    private UserDto userDto;
}

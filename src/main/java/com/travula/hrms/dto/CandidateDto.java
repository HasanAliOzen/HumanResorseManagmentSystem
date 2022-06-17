package com.travula.hrms.dto;

import lombok.Data;

@Data
public class CandidateDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String nationalityId;

    private int birthYear;

    private UserDto userDto;
}

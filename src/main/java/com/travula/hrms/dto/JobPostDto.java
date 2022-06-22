package com.travula.hrms.dto;

import lombok.Data;

import java.util.Date;

@Data
public class JobPostDto {

    private Long id;

    private String jobPositionName;

    private String jobDescription;

    private String jobCity;

    private double minSalary;

    private double maxSalary;

    private int emptyPositions;

    private Date deadline;

    private Date publicationDate;

    private boolean status;

    private String employerName;
}

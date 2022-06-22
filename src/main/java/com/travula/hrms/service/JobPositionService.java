package com.travula.hrms.service;

import com.travula.hrms.core.utilities.results.DataResult;
import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.dto.JobPositionDto;
import com.travula.hrms.entity.JobPosition;

import java.util.List;

public interface JobPositionService {
    Result addJob(JobPositionDto jobPositionDto);
    void addJob(String jobPositionName);

    DataResult<List<JobPositionDto>> getAllJobs();

    JobPosition getJobPosition(String name);

    boolean existsByJobName(String name);
}

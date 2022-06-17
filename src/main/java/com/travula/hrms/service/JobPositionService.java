package com.travula.hrms.service;

import com.travula.hrms.core.utilities.results.DataResult;
import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.dto.JobPositionDto;

import java.util.List;

public interface JobPositionService {
    public Result addJob(JobPositionDto jobPositionDto);

    public DataResult<List<JobPositionDto>> getAllJobs();

    public DataResult<JobPositionDto> deleteJob(Long id);
}

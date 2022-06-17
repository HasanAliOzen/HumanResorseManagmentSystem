package com.travula.hrms.service.impl;

import com.travula.hrms.core.utilities.results.DataResult;
import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.core.utilities.results.SuccessDataResult;
import com.travula.hrms.core.utilities.results.SuccessResult;
import com.travula.hrms.dto.JobPositionDto;
import com.travula.hrms.entity.JobPosition;
import com.travula.hrms.repo.JobPositionRepository;
import com.travula.hrms.service.JobPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPositionServiceImpl implements JobPositionService {

    private final JobPositionRepository jobPositionRepository;

    @Override
    public Result addJob(JobPositionDto jobPositionDto) {
        JobPosition jobPosition =new JobPosition();
        jobPosition.setJobName(jobPositionDto.getJobName());
        this.jobPositionRepository.save(jobPosition);
        return new SuccessResult("Job Added Successfully!!!");
    }

    @Override
    public DataResult<List<JobPositionDto>> getAllJobs() {
        List<JobPosition> jobPositions = this.jobPositionRepository.findAll();
        List<JobPositionDto> jobPositionDtos = new ArrayList<>();

        jobPositions.forEach(it->{
            JobPositionDto jobPositionDto = new JobPositionDto();
            jobPositionDto.setId(it.getId());
            jobPositionDto.setJobName(it.getJobName());

            jobPositionDtos.add(jobPositionDto);
        });
        return new SuccessDataResult<>(jobPositionDtos,"Jobs Listed Successfully!!!");
    }

    @Override
    public DataResult<JobPositionDto> deleteJob(Long id) {
        return null;
    }
}

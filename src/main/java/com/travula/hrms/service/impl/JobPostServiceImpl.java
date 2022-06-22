package com.travula.hrms.service.impl;

import com.travula.hrms.core.utilities.results.*;
import com.travula.hrms.dto.JobPostDto;
import com.travula.hrms.entity.JobPost;
import com.travula.hrms.repo.JobPostRepository;
import com.travula.hrms.service.EmployerService;
import com.travula.hrms.service.JobPositionService;
import com.travula.hrms.service.JobPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostServiceImpl implements JobPostService {
    private final JobPostRepository jobPostRepository;
    private final JobPositionService jobPositionService;
    private final EmployerService employerService;

    @Override
    public Result addJobPost(JobPostDto jobPostDto) {
        JobPost jobPost = new JobPost();
        if(!this.jobPositionService.existsByJobName(jobPostDto.getJobPositionName())){
            this.jobPositionService.addJob(jobPostDto.getJobPositionName());
        }
        jobPost.setJobPosition(this.jobPositionService.getJobPosition(jobPostDto.getJobPositionName()));
        jobPost.setJobDescription(jobPostDto.getJobDescription());
        jobPost.setJobCity(jobPostDto.getJobCity());
        jobPost.setMinSalary(jobPostDto.getMinSalary());
        jobPost.setMaxSalary(jobPostDto.getMaxSalary());
        jobPost.setDeadline(jobPostDto.getDeadline());
        jobPost.setPublicationDate(new Date());
        if(!this.employerService.existsByCompanyName(jobPostDto.getEmployerName())){
            return new ErrorResult("Failed to add!!! No Employer with this name!!!");
        }
        if(!this.employerService.getByCompanyName(jobPostDto.getEmployerName()).getUser().isEmailEnabled()){
            return new ErrorResult("Failed to add!!! Employer's email not verified yet!!!");
        }
        if(!this.employerService.getByCompanyName(jobPostDto.getEmployerName()).isEnabled()){
            return new ErrorResult("Failed to add!!! Employer not verified yet!!!");
        }

        jobPost.setEmployer(this.employerService.getByCompanyName(jobPostDto.getEmployerName()));
        jobPost.setEmptyPositions(jobPostDto.getEmptyPositions());
        jobPost.setStatus(true);

        this.jobPostRepository.save(jobPost);
        return new SuccessResult("Job Post Added Successfully!!!");
    }

    @Override
    public JobPostDto getJobPostDto(JobPost jobPost) {
        JobPostDto jobPostDto = new JobPostDto();
        jobPostDto.setId(jobPost.getId());
        jobPostDto.setJobPositionName(jobPost.getJobPosition().getJobName());
        jobPostDto.setJobDescription(jobPost.getJobDescription());
        jobPostDto.setJobCity(jobPost.getJobCity());
        jobPostDto.setMinSalary(jobPost.getMinSalary());
        jobPostDto.setMaxSalary(jobPost.getMaxSalary());
        jobPostDto.setEmptyPositions(jobPost.getEmptyPositions());
        jobPostDto.setDeadline(jobPost.getDeadline());
        jobPostDto.setPublicationDate(jobPost.getPublicationDate());
        jobPostDto.setStatus(jobPost.isStatus());
        jobPostDto.setEmployerName(jobPost.getEmployer().getCompanyName());
        return jobPostDto;
    }

    @Override
    public DataResult<List<JobPostDto>> listAllJobPosts() {
        List<JobPostDto> jobPostDtos = new ArrayList<>();
        this.jobPostRepository.findAll().forEach(it->{
            jobPostDtos.add(this.getJobPostDto(it));
        });

        return new SuccessDataResult<List<JobPostDto>>(jobPostDtos,"Job posts listed Successfully!!!");
    }

    @Override
    public DataResult<List<JobPostDto>> getJobPostsByStatus() {
        List<JobPostDto> jobPostDtos = new ArrayList<>();
        this.jobPostRepository.getJobPostsByStatus(true).forEach(it->{
            jobPostDtos.add(this.getJobPostDto(it));
        });

        return new SuccessDataResult<List<JobPostDto>>(jobPostDtos,"Active Job posts listed Successfully!!!");
    }

    @Override
    public DataResult<List<JobPostDto>> getJobPostsByStatusOrderByPublicationDateAsc() {
        List<JobPostDto> jobPostDtos = new ArrayList<>();
        this.jobPostRepository.getJobPostsByStatusOrderByPublicationDateAsc(true).forEach(it->{
            jobPostDtos.add(this.getJobPostDto(it));
        });

        return new SuccessDataResult<List<JobPostDto>>(jobPostDtos,"Active Job posts listed ordered publication date Successfully!!!");
    }

    @Override
    public DataResult<List<JobPostDto>> getJobPostsByStatusAndEmployerName(String employeName) {
        List<JobPostDto> jobPostDtos = new ArrayList<>();
        this.jobPostRepository.getJobPostsByStatusAndEmployer_CompanyName(true,employeName)
        .forEach(it->{
            jobPostDtos.add(this.getJobPostDto(it));
        });

        return new SuccessDataResult<List<JobPostDto>>(jobPostDtos,"Active Job posts for specified employer successfully!!!");
    }

    @Override
    public Result changeStatusOfJobPost(Long postId,boolean status){
        JobPost jobPost = this.jobPostRepository.getById(postId);
        jobPost.setStatus(status);
        this.jobPostRepository.save(jobPost);
        return  new SuccessResult("Post status changed!!!");
    }
}

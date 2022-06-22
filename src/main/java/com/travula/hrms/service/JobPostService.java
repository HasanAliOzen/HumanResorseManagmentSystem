package com.travula.hrms.service;

import com.travula.hrms.core.utilities.results.DataResult;
import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.dto.JobPostDto;
import com.travula.hrms.entity.JobPost;

import java.util.List;

public interface JobPostService {
    Result addJobPost(JobPostDto jobPostDto);

    JobPostDto getJobPostDto(JobPost jobPost);

    DataResult<List<JobPostDto>> listAllJobPosts();

    DataResult<List<JobPostDto>> getJobPostsByStatus ();

    DataResult<List<JobPostDto>> getJobPostsByStatusOrderByPublicationDateAsc();

    DataResult<List<JobPostDto>> getJobPostsByStatusAndEmployerName(String employeName);

    Result changeStatusOfJobPost(Long PostId,boolean status);
}

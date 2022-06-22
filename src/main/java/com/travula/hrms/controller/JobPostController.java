package com.travula.hrms.controller;

import com.travula.hrms.core.utilities.results.DataResult;
import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.dto.JobPostDto;
import com.travula.hrms.service.JobPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller/job-post/")
@RequiredArgsConstructor
public class JobPostController {
    private final JobPostService jobPostService;

    @PostMapping("add-job-post")
    Result addJobPost(@RequestBody JobPostDto jobPostDto){
        return this.jobPostService.addJobPost(jobPostDto);
    }

    @GetMapping("get-all-job-posts")
    DataResult<List<JobPostDto>> getAllJobPosts(){
        return this.jobPostService.listAllJobPosts();
    }

    @GetMapping("get-all-active-job-posts")
    DataResult<List<JobPostDto>> getJobPostsByStatus (){
        return this.jobPostService.getJobPostsByStatus();
    }

    @GetMapping("get-all-active-job-posts-ordered-by-publication")
    DataResult<List<JobPostDto>> getAllJobPostsByPublication(){
        return this.jobPostService.getJobPostsByStatusOrderByPublicationDateAsc();
    }

    @GetMapping("get-all-active-job-posts-by-employer")
    DataResult<List<JobPostDto>> getJobPostsByStatusAndEmployerName(@RequestParam String employerName){
        return this.jobPostService.getJobPostsByStatusAndEmployerName(employerName);
    }

    @PostMapping("change-status")
    public Result changeStatusOfJobPost(@RequestParam Long postId,@RequestParam boolean status){
        return this.jobPostService.changeStatusOfJobPost(postId,status);
    }
}

package com.travula.hrms.controller;

import com.travula.hrms.core.utilities.results.DataResult;
import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.dto.JobPositionDto;
import com.travula.hrms.service.JobPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobposition/")
@RequiredArgsConstructor
public class JobPositionController {

    private final JobPositionService jobPositionService;

    @PostMapping("addjob")
    public Result addJob(@RequestBody JobPositionDto jobPositionDto){
        return this.jobPositionService.addJob(jobPositionDto);
    }

    @GetMapping("getalljobs")
    public DataResult<List<JobPositionDto>> getAllJobs(){
        return jobPositionService.getAllJobs();
    }
}

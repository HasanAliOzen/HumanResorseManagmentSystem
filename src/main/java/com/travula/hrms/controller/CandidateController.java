package com.travula.hrms.controller;

import com.travula.hrms.core.utilities.results.DataResult;
import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.dto.CandidateDto;
import com.travula.hrms.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller/candidate/")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping("add-candidate")
    public Result addCandidate(@RequestBody CandidateDto candidateDto){
        return this.candidateService.addCandidate(candidateDto);
    }

    @GetMapping("get-all-candidates")
    public DataResult<List<CandidateDto>> getAllCandidates(){
        return this.candidateService.getAllCandidates();
    }
}

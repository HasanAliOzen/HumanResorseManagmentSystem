package com.travula.hrms.controller;

import com.travula.hrms.core.utilities.results.DataResult;
import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.dto.CandidateDto;
import com.travula.hrms.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate/")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping("addcandidate")
    public Result addCandidate(@RequestBody CandidateDto candidateDto){
        return this.candidateService.addCandidate(candidateDto);
    }

    @GetMapping("getallcandidates")
    public DataResult<List<CandidateDto>> getAllCandidates(){
        return this.candidateService.getAllCandidates();
    }
}

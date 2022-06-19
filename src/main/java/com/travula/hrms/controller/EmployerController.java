package com.travula.hrms.controller;

import com.travula.hrms.core.utilities.results.DataResult;
import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.core.utilities.results.SuccessResult;
import com.travula.hrms.dto.CandidateDto;
import com.travula.hrms.dto.EmployerDto;
import com.travula.hrms.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer/")
@RequiredArgsConstructor
public class EmployerController {

    private final EmployerService employerService;

    @PostMapping("addemployer")
    public Result addEmployer(@RequestBody EmployerDto employerDto){
        return this.employerService.addEmployer(employerDto);
    }

    @GetMapping("getallemployers")
    public DataResult<List<EmployerDto>> getAllEmployers(){
        return this.employerService.listEmployers();
    }
}

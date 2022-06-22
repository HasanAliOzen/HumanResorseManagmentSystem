package com.travula.hrms.controller;

import com.travula.hrms.core.utilities.results.DataResult;
import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.dto.EmployerDto;
import com.travula.hrms.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller/employer/")
@RequiredArgsConstructor
public class EmployerController {

    private final EmployerService employerService;

    @PostMapping("add-employer")
    public Result addEmployer(@RequestBody EmployerDto employerDto){
        return this.employerService.addEmployer(employerDto);
    }

    @GetMapping("get-all-employers")
    public DataResult<List<EmployerDto>> getAllEmployers(){
        return this.employerService.listEmployers();
    }
}

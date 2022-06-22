package com.travula.hrms.service.impl;

import com.travula.hrms.core.utilities.results.ErrorResult;
import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.core.utilities.results.SuccessResult;
import com.travula.hrms.entity.Employer;
import com.travula.hrms.entity.SystemPersonal;
import com.travula.hrms.repo.SysPersonalRepository;
import com.travula.hrms.service.EmployerService;
import com.travula.hrms.service.SysPersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SysPersonalServiceImpl implements SysPersonalService {

    private final SysPersonalRepository sysPersonalRepository;
    private final EmployerService employerService;


    @Override
    public Result enableEmployer(Long personalId, Long employerId) {
        if(!this.sysPersonalRepository.existsById(personalId)){
            return  new ErrorResult("Failed!!! No personal with this id!!!");
        }
        if (!this.employerService.existsById(employerId)){
            return  new ErrorResult("Failed!!! No employer with this id!!!");
        }

        Employer employer = this.employerService.getEmployerById(employerId);

        employer.setEnabled(true);

        this.employerService.saveEmployer(employer);
        return new SuccessResult("Employer verified");
    }
}

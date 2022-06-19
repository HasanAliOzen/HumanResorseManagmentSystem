package com.travula.hrms.service;

import com.travula.hrms.core.utilities.results.DataResult;
import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.dto.EmployerDto;

import java.util.List;

public interface EmployerService {
    Result addEmployer(EmployerDto employerDto);
    DataResult<List<EmployerDto>> listEmployers();
}

package com.travula.hrms.service;

import com.travula.hrms.core.utilities.results.DataResult;
import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.dto.EmployerDto;
import com.travula.hrms.entity.Employer;

import java.util.List;

public interface EmployerService {
    Result addEmployer(EmployerDto employerDto);

    void saveEmployer(Employer employer);
    DataResult<List<EmployerDto>> listEmployers();

    boolean existsById (Long id);

    Employer getEmployerById(Long id);
}

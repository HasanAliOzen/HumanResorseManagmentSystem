package com.travula.hrms.service.impl;

import com.travula.hrms.core.utilities.results.DataResult;
import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.core.utilities.results.SuccessDataResult;
import com.travula.hrms.core.utilities.results.SuccessResult;
import com.travula.hrms.dto.EmployerDto;
import com.travula.hrms.entity.Employer;
import com.travula.hrms.entity.User;
import com.travula.hrms.repo.EmployerRepository;
import com.travula.hrms.service.EmployerService;
import com.travula.hrms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;
    private final UserService userService;


    @Override
    public Result addEmployer(EmployerDto employerDto) {


        Employer employer = new Employer();
        employer.setCompanyName(employerDto.getCompanyName());
        employer.setWebPage(employerDto.getWebPage());
        employer.setPhoneNumber(employerDto.getPhoneNumber());

        User user = this.userService.add(employerDto.getUserDto());

        employer.setUser(user);

        this.employerRepository.save(employer);
        return new SuccessResult("Employer user added Successfully!!!");
    }

    @Override
    public DataResult<List<EmployerDto>> listEmployers() {
        List<EmployerDto> employerDtos = new ArrayList<>();
        this.employerRepository.findAll().forEach(it->{
            EmployerDto employerDto = new EmployerDto();
            employerDto.setId(it.getId());
            employerDto.setCompanyName(it.getCompanyName());
            employerDto.setWebPage(it.getWebPage());
            employerDto.setPhoneNumber(it.getPhoneNumber());
            employerDto.setUserDto(this.userService.getUserDto(it.getUser()));

            employerDtos.add(employerDto);
        });

        return new SuccessDataResult<>(employerDtos,"Listed Successfully");
    }
}

package com.travula.hrms.service.impl;

import com.travula.hrms.core.utilities.results.*;
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

        if(this.userService.isEmailExist(employerDto.getUserDto().getEmail())){
            return new ErrorResult("Cannot add employer because email already exist!!!");
        }

        Employer employer = new Employer();
        employer.setCompanyName(employerDto.getCompanyName());
        employer.setWebPage(employerDto.getWebPage());
        employer.setPhoneNumber(employerDto.getPhoneNumber());
        employer.setEnabled(false);
        employer.setEnablerSystemPersonal(null);

        User user = this.userService.add(employerDto.getUserDto());

        employer.setUser(user);

        this.employerRepository.save(employer);
        return new SuccessResult("Employer user added Successfully!!!");
    }

    @Override
    public void saveEmployer(Employer employer) {
        //TODO
        this.employerRepository.save(employer);
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
            employerDto.setEnabled(it.isEnabled());

            employerDto.setUserDto(this.userService.getUserDto(it.getUser()));

            employerDtos.add(employerDto);
        });

        return new SuccessDataResult<>(employerDtos,"Listed Successfully");
    }

    @Override
    public boolean existsById(Long id) {
        return this.employerRepository.existsById(id);
    }

    @Override
    public Employer getEmployerById(Long id) {
        return this.employerRepository.getReferenceById(id);
    }
}

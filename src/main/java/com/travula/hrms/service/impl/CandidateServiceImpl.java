package com.travula.hrms.service.impl;

import com.travula.hrms.core.utilities.results.*;
import com.travula.hrms.dto.CandidateDto;
import com.travula.hrms.entity.Candidate;
import com.travula.hrms.entity.User;
import com.travula.hrms.repo.CandidateRepository;
import com.travula.hrms.service.CandidateService;
import com.travula.hrms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final UserService userService;
    private final CandidateRepository candidateRepository;


    @Override
    @Transactional
    public Result addCandidate(CandidateDto candidateDto) {
        // TODO Mernis and Email

        //Checks is email or nationality id already exist
        if(this.userService.isEmailExist(candidateDto.getUserDto().getEmail())){
            return new ErrorResult("Cannot add candidate because email already exist!!!");
        } else if (this.candidateRepository.existsCandidateByNationalityId(candidateDto.getNationalityId())) {
            return  new ErrorResult("Cannot add candidate because nationality id already exist!!!");
        }




        Candidate candidate = new Candidate();
        candidate.setFirstName(candidateDto.getFirstName());
        candidate.setLastName(candidateDto.getLastName());
        candidate.setNationalityId(candidateDto.getNationalityId());
        candidate.setBirthYear(candidateDto.getBirthYear());

        User user = userService.add(candidateDto.getUserDto());

        candidate.setUser(user);

        this.candidateRepository.save(candidate);
        return new SuccessResult("Candidate user added Successfully!!!");
    }

    @Override
    public DataResult<List<CandidateDto>> getAllCandidates() {
        List<CandidateDto> candidateDtos = new ArrayList<>();
        this.candidateRepository.findAll().forEach(it->{
            CandidateDto candidateDto = new CandidateDto();
            candidateDto.setId(it.getId());
            candidateDto.setFirstName(it.getFirstName());
            candidateDto.setLastName(it.getLastName());
            candidateDto.setNationalityId(it.getNationalityId());
            candidateDto.setBirthYear(it.getBirthYear());
            candidateDto.setUserDto(this.userService.getUserDto(it.getUser()));

            candidateDtos.add(candidateDto);
        });

        return new SuccessDataResult(candidateDtos,"Listed Successfully");
    }
}

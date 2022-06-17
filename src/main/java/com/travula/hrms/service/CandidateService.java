package com.travula.hrms.service;

import com.travula.hrms.core.utilities.results.DataResult;
import com.travula.hrms.core.utilities.results.Result;
import com.travula.hrms.dto.CandidateDto;

import java.util.List;

public interface CandidateService {
    Result addCandidate(CandidateDto candidateDto);

    DataResult<List<CandidateDto>> getAllCandidates();


}

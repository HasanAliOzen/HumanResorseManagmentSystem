package com.travula.hrms.repo;

import com.travula.hrms.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {
    Boolean existsCandidateByNationalityId (String nationalityId);
}

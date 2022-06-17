package com.travula.hrms.repo;

import com.travula.hrms.entity.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionRepository extends JpaRepository<JobPosition,Long> {
}

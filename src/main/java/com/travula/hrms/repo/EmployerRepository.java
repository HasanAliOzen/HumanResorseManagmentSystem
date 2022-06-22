package com.travula.hrms.repo;

import com.travula.hrms.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer,Long> {
    boolean existsById (Long id);
    boolean existsByCompanyName (String name);
    Employer getByCompanyName(String name);

}

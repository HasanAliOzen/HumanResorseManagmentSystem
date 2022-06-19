package com.travula.hrms.repo;

import com.travula.hrms.entity.SystemPersonal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysPersonalRepository extends JpaRepository<SystemPersonal,Long> {
    boolean existsById (Long id);
}

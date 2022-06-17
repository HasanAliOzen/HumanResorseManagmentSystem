package com.travula.hrms.repo;

import com.travula.hrms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsUserByEmail (String email);
}

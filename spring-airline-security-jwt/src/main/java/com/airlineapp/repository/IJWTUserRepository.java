package com.airlineapp.repository;

import com.airlineapp.model.JWTUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJWTUserRepository extends JpaRepository<JWTUser,Integer> {
    JWTUser findByUsername(String username);
}

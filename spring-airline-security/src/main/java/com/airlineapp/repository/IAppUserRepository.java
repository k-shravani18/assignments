package com.airlineapp.repository;

import com.airlineapp.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUsername(String username);
}

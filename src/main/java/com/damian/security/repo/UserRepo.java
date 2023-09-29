package com.damian.security.repo;

import com.damian.security.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserDetails,String> {
    Optional<UserDetails> findByUserName (String username);
}

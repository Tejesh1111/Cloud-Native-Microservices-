package com.tejesh.teamflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tejesh.teamflow.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

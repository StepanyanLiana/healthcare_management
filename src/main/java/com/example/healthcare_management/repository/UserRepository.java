package com.example.healthcare_management.repository;

import com.example.healthcare_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
Optional<User> findByEmail(String email);
}

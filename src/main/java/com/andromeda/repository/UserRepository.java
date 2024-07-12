package com.example.andromeda.repository;

import com.example.andromeda.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

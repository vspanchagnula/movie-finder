package com.movieapp.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieapp.data.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
        User findByUsername(String username);
}

package com.tcs.attendance.repo;

import com.tcs.attendance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer>{
    Optional<User> findByUsername(String username);
}
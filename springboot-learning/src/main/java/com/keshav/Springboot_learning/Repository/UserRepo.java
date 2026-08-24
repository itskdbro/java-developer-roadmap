package com.keshav.Springboot_learning.Repository;

import com.keshav.Springboot_learning.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findUserByUsername(String username);
}

package com.example.Challenge7.repository;

import com.example.Challenge7.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,String> {
    Optional<Users> findByUserName(String UserName);
    Boolean existsByUserName(String UserName);
    Boolean existsByEmail(String email);
    Optional<Users> findByuserName(String login);
}

package com.example.Challenge7.repository;

import com.example.Challenge7.enumeration.ERole;
import com.example.Challenge7.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {

    Optional<Roles> findByRoleName(ERole name);
}

package com.gusmelford.gusmelfordbooks_spring.repositories;

import com.gusmelford.gusmelfordbooks_spring.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(@Param("name") String name);
}

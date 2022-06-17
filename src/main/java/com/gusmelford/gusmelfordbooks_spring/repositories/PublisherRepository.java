package com.gusmelford.gusmelfordbooks_spring.repositories;

import com.gusmelford.gusmelfordbooks_spring.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, UUID> {
}

package com.example.microservice.repositoryemployeer;

import com.example.microservice.modelemployeer.Employeer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEmployyer extends JpaRepository<Employeer,Long> {
}

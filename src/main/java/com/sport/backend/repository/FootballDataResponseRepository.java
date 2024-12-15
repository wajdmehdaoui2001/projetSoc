package com.sport.backend.repository;

import com.sport.backend.models.FootballDataResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballDataResponseRepository extends JpaRepository<FootballDataResponse, Long> {
}

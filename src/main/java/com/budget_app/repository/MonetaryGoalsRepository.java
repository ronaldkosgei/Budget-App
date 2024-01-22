package com.budget_app.repository;

import com.budget_app.entity.MonetaryGoals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonetaryGoalsRepository extends JpaRepository<MonetaryGoals, Long> {
}

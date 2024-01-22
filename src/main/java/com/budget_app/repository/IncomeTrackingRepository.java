package com.budget_app.repository;

import com.budget_app.entity.IncomeTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeTrackingRepository extends JpaRepository<IncomeTracking, Long> {
}

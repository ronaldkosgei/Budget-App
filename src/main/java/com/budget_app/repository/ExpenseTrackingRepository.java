package com.budget_app.repository;

import com.budget_app.entity.ExpenseTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseTrackingRepository extends JpaRepository<ExpenseTracking, Long> {
}

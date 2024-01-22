package com.budget_app.repository;

import com.budget_app.entity.BudgetManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetManagementRepository extends JpaRepository<BudgetManagement, Long>{
}

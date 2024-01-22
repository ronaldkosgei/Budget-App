package com.budget_app.repository;

import com.budget_app.entity.SharingGoals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharingGoalsRepository extends JpaRepository<SharingGoals, Long> {
}

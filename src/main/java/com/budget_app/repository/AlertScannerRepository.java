package com.budget_app.repository;

import com.budget_app.entity.AlertScanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlertScannerRepository extends JpaRepository<AlertScanner, Long> {
}

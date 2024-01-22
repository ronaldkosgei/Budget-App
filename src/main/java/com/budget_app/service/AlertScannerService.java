package com.budget_app.service;

import com.budget_app.dto.AlertScannerDto;
import com.budget_app.entity.AlertScanner;

import java.util.List;
import java.util.Optional;

public interface AlertScannerService {

    AlertScannerDto saveAlertScanner(AlertScannerDto alertScannerDto);

    Optional<AlertScannerDto> getAlertScannerById(Long alertScannerId);

    List<AlertScannerDto> getAllAlertScanners();

    Optional<AlertScannerDto> updateAlertScanner(Long alertScannerId, AlertScannerDto alertScannerDto);

    Optional<Object> deleteAlertScanner(Long alertScannerId);
}

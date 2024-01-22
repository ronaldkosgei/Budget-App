package com.budget_app.mapper;

import com.budget_app.dto.AlertScannerDto;
import com.budget_app.entity.AlertScanner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AlertScannerMapper {

    public static AlertScanner toEntity(AlertScannerDto alertScannerDto) {
        AlertScanner alertScanner = new AlertScanner();
        alertScanner.setAlertId(alertScannerDto.getAlertId());
        alertScanner.setUserId(alertScannerDto.getUserId());
        alertScanner.setAlertText(alertScannerDto.getAlertText());
        alertScanner.setCreatedAt(alertScannerDto.getCreatedAt());
        alertScanner.setStatus(alertScannerDto.getStatus());

        return alertScanner;
    }

    public static AlertScannerDto toDto(AlertScanner alertScanner) {
        AlertScannerDto alertScannerDto = new AlertScannerDto();
        alertScannerDto.setAlertId(alertScanner.getAlertId());
        alertScannerDto.setAlertText(alertScanner.getAlertText());
        alertScannerDto.setUserId(alertScanner.getUserId());
        alertScannerDto.setCreatedAt(alertScanner.getCreatedAt());
        alertScannerDto.setStatus(alertScanner.getStatus());

        return alertScannerDto;
    }

    public static void updateEntity(AlertScannerDto alertScannerDto, AlertScanner alertScanner) {
        alertScanner.setAlertText(alertScannerDto.getAlertText());
        alertScanner.setUserId(alertScannerDto.getUserId());
        alertScanner.setCreatedAt(alertScannerDto.getCreatedAt());
        alertScanner.setStatus(alertScannerDto.getStatus());
    }
}

package com.budget_app.controller;


import com.budget_app.dto.AlertScannerDto;
import com.budget_app.service.AlertScannerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scanner")
public class AlertScannerController {

    private final AlertScannerService alertScannerService;

    public AlertScannerController(AlertScannerService alertScannerService) {
        this.alertScannerService = alertScannerService;
    }

    @PostMapping("/create")
    public AlertScannerDto saveAlertScanner(@RequestBody AlertScannerDto alertScannerDto) {
        return alertScannerService.saveAlertScanner(alertScannerDto);
    }

    @GetMapping("/get/{alertScannerId}")
    public Optional<AlertScannerDto> getAlertScannerById(@PathVariable Long alertScannerId) {
        return alertScannerService.getAlertScannerById(alertScannerId);
    }

    @GetMapping("/get/all")
    public List<AlertScannerDto> getAllAlertScanners() {
        return alertScannerService.getAllAlertScanners();
    }

    @PutMapping("/update/{alertScannerId}")
    public Optional<AlertScannerDto> updateAlertScanner(@PathVariable Long alertScannerId, @RequestBody AlertScannerDto alertScannerDto) {
        return alertScannerService.updateAlertScanner(alertScannerId, alertScannerDto);
    }

    @DeleteMapping("/delete/{alertScannerId}")
    public Optional<Object> deleteAlertScanner(@PathVariable Long alertScannerId) {
        return alertScannerService.deleteAlertScanner(alertScannerId);
    }
}

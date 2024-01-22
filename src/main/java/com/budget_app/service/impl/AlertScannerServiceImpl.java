package com.budget_app.service.impl;

import com.budget_app.dto.AlertScannerDto;
import com.budget_app.entity.AlertScanner;
import com.budget_app.mapper.AlertScannerMapper;
import com.budget_app.repository.AlertScannerRepository;
import com.budget_app.service.AlertScannerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AlertScannerServiceImpl implements AlertScannerService {

    private final AlertScannerRepository alertScannerRepository;

    private final AlertScannerMapper alertScannerMapper;

    public AlertScannerServiceImpl(AlertScannerRepository alertScannerRepository, AlertScannerMapper alertScannerMapper) {
        this.alertScannerRepository = alertScannerRepository;
        this.alertScannerMapper = alertScannerMapper;
    }

    @Override
    public AlertScannerDto saveAlertScanner(AlertScannerDto alertScannerDto) {
        AlertScanner alertScanner = alertScannerMapper.toEntity(alertScannerDto);
        AlertScanner savedAlertScanner = alertScannerRepository.save(alertScanner);
        return alertScannerMapper.toDto(savedAlertScanner);
    }

    @Override
    public Optional<AlertScannerDto> getAlertScannerById(Long alertScannerId) {
        Optional<AlertScanner> alertScanner = alertScannerRepository.findById(alertScannerId);
        return alertScanner.map(AlertScannerMapper::toDto);
    }

    @Override
    public List<AlertScannerDto> getAllAlertScanners() {
        List<AlertScanner> allAlertScanners = alertScannerRepository.findAll();
        return allAlertScanners.stream()
                .map(AlertScannerMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public Optional<AlertScannerDto> updateAlertScanner(Long alertScannerId, AlertScannerDto alertScannerDto) {
        try {
            Optional<AlertScanner> alertScannerOptional = alertScannerRepository.findById(alertScannerId);

            if (alertScannerOptional.isPresent()) {
                AlertScanner existingAlertScanner = alertScannerOptional.get();
                alertScannerMapper.updateEntity(alertScannerDto, existingAlertScanner);
                AlertScanner updatedAlertScanner = alertScannerRepository.save(existingAlertScanner);
                return Optional.of(alertScannerMapper.toDto(updatedAlertScanner));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Object> deleteAlertScanner(Long alertScannerId) {
        try {
            Optional<AlertScanner> alertScannerOptional = alertScannerRepository.findById(alertScannerId);

            if (alertScannerOptional.isPresent()) {
                AlertScanner existingAlertScanner = alertScannerOptional.get();
                alertScannerRepository.delete(existingAlertScanner);
                return Optional.of(alertScannerMapper.toDto(existingAlertScanner));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}

package com.budget_app.service.impl;

import com.budget_app.dto.ReportDto;
import com.budget_app.entity.Report;
import com.budget_app.mapper.ReportMapper;
import com.budget_app.repository.ReportRepository;
import com.budget_app.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    private final ReportMapper reportMapper;

    public ReportServiceImpl(ReportRepository reportRepository, ReportMapper reportMapper){
        this.reportRepository = reportRepository;
        this.reportMapper = reportMapper;
    }

    @Override
    public ReportDto saveReport(ReportDto reportDto) {
        Report report = reportMapper.toEntity(reportDto);
        report = reportRepository.save(report);
        return reportMapper.toDto(report);
    }

    @Override
    public Optional<ReportDto> getReport(Long reportId) {
        try {
            Optional<Report> report = reportRepository.findById(reportId);
            if (report.isPresent()) {
                return Optional.of(reportMapper.toDto(report.get()));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<ReportDto> getAllReports() {
        List<Report> reports = reportRepository.findAll();
        return reports.stream()
                .map(ReportMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ReportDto> updateReportById(Long reportId, ReportDto reportDto) {
        try {
            Optional<Report> reportOptional = reportRepository.findById(reportId);
            if (reportOptional.isPresent()){
                Report existingReport = reportOptional.get();
                Report updatedReport = reportRepository.save(existingReport);
                return Optional.of(reportMapper.toDto(updatedReport));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ReportDto> deleteReportById(Long reportId) {
        try {
            Optional<Report> reportOptional = reportRepository.findById(reportId);
            if (reportOptional.isPresent()){
                Report existingReport = reportOptional.get();
                reportRepository.delete(existingReport);
                return Optional.of(reportMapper.toDto(existingReport));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}

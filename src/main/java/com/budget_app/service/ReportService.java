package com.budget_app.service;

import com.budget_app.dto.ReportDto;
import com.budget_app.entity.Report;

import java.util.List;
import java.util.Optional;

public interface ReportService {

    ReportDto saveReport(ReportDto reportDto);

    Optional<ReportDto> getReport(Long reportId);

    List<ReportDto> getAllReports();

    Optional<ReportDto> updateReportById(Long reportId, ReportDto reportDto);

    Optional<ReportDto> deleteReportById(Long reportId);
}

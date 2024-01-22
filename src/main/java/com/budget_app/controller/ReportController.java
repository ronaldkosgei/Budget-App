package com.budget_app.controller;

import com.budget_app.dto.ReportDto;
import com.budget_app.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/generate")
    public ReportDto saveReport(@RequestBody ReportDto reportDto) {
        return reportService.saveReport(reportDto);
    }

    @GetMapping("/get/{reportId}")
    public Optional<ReportDto> getReport(@PathVariable Long reportId) {
        return reportService.getReport(reportId);
    }

    @GetMapping("/get/all")
    public List<ReportDto> getAllReports() {
        return reportService.getAllReports();
    }

    @PutMapping("/update/{reportId}")
    public Optional<ReportDto> updateReportById(@PathVariable Long reportId, @RequestBody ReportDto reportDto) {
        return reportService.updateReportById(reportId, reportDto);
    }

    @DeleteMapping("/delete/{reportId}")
    public void deleteReportById(@PathVariable Long reportId) {
        reportService.deleteReportById(reportId);
    }

}

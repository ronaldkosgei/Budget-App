package com.budget_app.mapper;

import com.budget_app.dto.ReportDto;
import com.budget_app.entity.Report;
import org.springframework.stereotype.Component;

@Component
public class ReportMapper {

    public static Report toEntity(ReportDto reportDto){
        Report report = new Report();
        report.setReportId(reportDto.getReportId());
        report.setUserId(reportDto.getUserId());
        report.setReportName(reportDto.getReportName());
        report.setCreatedAt(reportDto.getCreatedAt());
        report.setStatus(reportDto.getStatus());

        return report;
    }

    public static ReportDto toDto(Report report){
        ReportDto reportDto = new ReportDto();
        reportDto.setReportId(report.getReportId());
        reportDto.setUserId(report.getUserId());
        reportDto.setReportName(report.getReportName());
        reportDto.setCreatedAt(report.getCreatedAt());
        reportDto.setStatus(report.getStatus());

        return reportDto;
    }

    public static void updateEntity(Report report, ReportDto reportDto){
        report.setUserId(reportDto.getUserId());
        report.setReportName(reportDto.getReportName());
        report.setCreatedAt(reportDto.getCreatedAt());
        report.setStatus(reportDto.getStatus());
    }
}

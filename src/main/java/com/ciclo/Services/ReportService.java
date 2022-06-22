package com.ciclo.Services;

import com.ciclo.Dto.ReportRequest;
import com.ciclo.Entities.Report;
import com.ciclo.Repositories.ReportRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ReportService {
    private ReportRepository reportRepository;
    public ReportService(ReportRepository reportRepository) {this.reportRepository = reportRepository;}

    @Transactional
    public Report createReport(ReportRequest reportRequest) {
        Report reportNew = initReport(reportRequest);
        return reportRepository.save(reportNew);
    }
    public List<Report> getAllReports() { return reportRepository.getAllReports(); }

	 private Report initReport(ReportRequest reportRequest) {
	 Report reportObj = new Report();
     reportObj.setDateReport(new Date());
     reportObj.setDescription(reportRequest.getDescription());
     reportObj.setIdUser(reportRequest.getIdUser());
     return reportObj;
	 }

}

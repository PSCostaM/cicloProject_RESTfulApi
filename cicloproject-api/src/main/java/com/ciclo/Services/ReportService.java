package com.ciclo.Services;

import java.util.UUID;

import com.ciclo.Dto.ReportRequest;
import com.ciclo.Entities.Report;
import com.ciclo.Repositories.ReportRepository;

import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private ReportRepository reportRepository;

    public ReportService(ReportRepository repository) {
        this.reportRepository = repository;
    }

    private Report initReport(ReportRequest reportRequest) {
        Report reportObj = new Report();
        reportObj.setIdReport(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        reportObj.setDateReport(reportRequest.getDateReport());
        reportObj.setDescription(reportRequest.getDescription());
        reportObj.setIdUsuario(reportRequest.getIdUser());
        return reportObj;
    }

}

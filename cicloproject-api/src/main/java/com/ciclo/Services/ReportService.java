package com.example.demo.services;

import org.springframework.transaction.annotation.Transactional.*;

import java.util.List;
import java.util.UUID;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service.*;

import com.example.demo.dto.ReportRequest;
import com.example.demo.entities.Report;
import com.example.demo.repository.ReportRepository;
import com.example.demo.util.ReportValidator;

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
        ;
    }

}

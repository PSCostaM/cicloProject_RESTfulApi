package com.ciclo.Controllers;

import com.ciclo.Dto.ReportRequest;
import com.ciclo.Dto.ReportResponse;
import com.ciclo.Entities.Report;
import com.ciclo.Services.ReportService;

import com.ciclo.Util.ReportDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {
    private ReportService reportService;

    private ReportDtoConverter converter;

    public ReportController(ReportService reportService,ReportDtoConverter converter){
        this.reportService = reportService;
        this.converter = converter;
    }

    @PostMapping
    public ResponseEntity<ReportResponse> createReport(@RequestBody ReportRequest request) {
        Report report = reportService.createReport(request);
        return new ResponseEntity<>(converter.convertReportToDto(report), HttpStatus.CREATED);
    }

    @GetMapping("/findReports")
    public ResponseEntity<List<ReportResponse>> findReports() {
        List<Report> reports = reportService.getAllReports();
        return new ResponseEntity<>(converter.convertReportToDto(reports),HttpStatus.OK);
    }
}

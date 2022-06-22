package com.ciclo.Util;

import java.util.List;
import com.ciclo.Dto.ReportResponse;
import com.ciclo.Entities.Report;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ReportDtoConverter {
    private ModelMapper modelMapper;

    public ReportDtoConverter(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public ReportResponse convertReportToDto(Report report){
        return modelMapper.map(report, ReportResponse.class);
    }

    public List<ReportResponse> convertReportToDto(List<Report> reports) {
        return reports.stream()
                .map(report->convertReportToDto(report))
                .collect(Collectors.toList());
    }
}

package com.ciclo.Util;

import java.util.List;
import java.util.stream.Collectors;

import com.ciclo.Dto.ReportResponse;
import com.ciclo.Entities.Report;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter {

    private ModelMapper modelMapper;

    public EntityDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ReportResponse convertEntityToDto(Report report) {
        return modelMapper.map(report, ReportResponse.class);
    }

    public List<ReportResponse> convertEntityToDto(List<Report> reports) {
        return reports.stream()
                .map(report -> convertEntityToDto(report))
                .collect(Collectors.toList());
    }
}

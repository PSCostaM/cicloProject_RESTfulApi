package com.example.demo.util;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.ReportResponse;
import com.example.demo.entities.Report;

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

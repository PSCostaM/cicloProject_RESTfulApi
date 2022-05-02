package com.example.demo.dto;

import com.example.demo.entities.User;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ReportRequest {
    @NotBlank
    private String IdReport;
    @NotBlank
    private String dateReport;
    private String description;
    private User idUser;
}

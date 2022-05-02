package com.ciclo.Dto;


import javax.validation.constraints.NotBlank;

import com.ciclo.Entities.User;

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

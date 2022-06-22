package com.ciclo.Dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReportResponse {
    private long IdReport;
    private Date dateReport;
    private String description;
    private long idUser;
}

package com.example.demo.util;

import com.example.demo.dto.ReportRequest;
import com.example.demo.exception.IncorrectReportRequestException;

public class ReportValidator {
    public static boolean validateReport(ReportRequest reportRequest) {
        if (reportRequest.getIdUser() == null || reportRequest.getDateReport() == null
                || reportRequest.getDescription() == null || reportRequest.getIdReport() == null) {
            throw new IncorrectReportRequestException("Report Request incorrecto");
        }
        return true;
    }
}

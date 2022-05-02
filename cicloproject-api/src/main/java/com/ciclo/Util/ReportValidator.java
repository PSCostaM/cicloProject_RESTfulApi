package com.ciclo.Util;

import com.ciclo.Dto.ReportRequest;
import com.ciclo.exception.IncorrectReportRequestException;

public class ReportValidator {
    public static boolean validateReport(ReportRequest reportRequest) {
        if (reportRequest.getIdUser() == null || reportRequest.getDateReport() == null
                || reportRequest.getDescription() == null || reportRequest.getIdReport() == null) {
            throw new IncorrectReportRequestException("Report Request incorrecto");
        }
        return true;
    }
}

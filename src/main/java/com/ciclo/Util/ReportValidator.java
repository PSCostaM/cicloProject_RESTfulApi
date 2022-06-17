package com.ciclo.Util;

import com.ciclo.Dto.ReportRequest;
import com.ciclo.exception.IncorrectReportRequestException;

public class ReportValidator {
    public static boolean validateCreate(ReportRequest reportDto){
        if(reportDto.getDescription() == null || reportDto.getDescription().isEmpty() || reportDto.getDescription().isBlank())
            throw new IncorrectReportRequestException("La descripcion del reporte no puede ser vacio o nulo");
        return true;
    }
}

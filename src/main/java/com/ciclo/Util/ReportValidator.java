package com.ciclo.Util;

import com.ciclo.Dto.ReportRequest;
import com.ciclo.exception.IncorrectReportRequestException;

public class ReportValidator {
    public static boolean validateCreate(ReportRequest reportDto, boolean repeatedId){
        if(reportDto.getDescription() == null || reportDto.getDescription().isEmpty() || reportDto.getDescription().isBlank())
            throw new IncorrectReportRequestException("La descripcion del reporte no puede ser vacio o nulo");
        else if(repeatedId)
            throw new IncorrectReportRequestException("El usuario ya tiene un reporte en esta ciclovía");
        return true;
    }
}

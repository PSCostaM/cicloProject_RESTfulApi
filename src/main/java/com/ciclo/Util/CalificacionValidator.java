package com.ciclo.Util;

import com.ciclo.Dto.CalificacionRequestDto;
import com.ciclo.Entities.Calificacion;
import com.ciclo.exception.IncorrectReportRequestException;

public class CalificacionValidator {
    public static boolean validateCreate(CalificacionRequestDto calificacionDto){
        if(calificacionDto.getDescripcionCalificacion() == null || calificacionDto.getDescripcionCalificacion().isEmpty() || calificacionDto.getDescripcionCalificacion().isBlank())
            throw new IncorrectReportRequestException("La descripcion de la calificacion no puede ser vacia o nula");
        else if(calificacionDto.getEstrellasCalificacion() < 1 || calificacionDto.getEstrellasCalificacion() > 5)
            throw new IncorrectReportRequestException("La calificacion debe estar entre 1 y 5");
        return true;
    }

    public static boolean validateGetCalificacion(Calificacion calificacion){
        if(calificacion == null)
            throw new IncorrectReportRequestException("La calificacion no fue encontrada");
        return true;
    }
}

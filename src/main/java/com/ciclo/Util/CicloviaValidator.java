package com.ciclo.Util;

import com.ciclo.Dto.CicloviaRequestDto;
import com.ciclo.Entities.Ciclovia;
import com.ciclo.exception.IncorrectReportRequestException;

public class CicloviaValidator {
    public static boolean validateCreate(CicloviaRequestDto cicloviaDto){
        if(cicloviaDto.getNombreCiclovia() == null || cicloviaDto.getNombreCiclovia().isEmpty() || cicloviaDto.getNombreCiclovia().isBlank())
            throw new IncorrectReportRequestException("El nombre de la ciclovia no puede ser vacio o nulo");
        return true;
    }

    public static boolean validateGetByCiclovia(Ciclovia ciclovia){
        if(ciclovia == null)
            throw new IncorrectReportRequestException("La ciclovia no fue encontrada");
        return true;
    }
}

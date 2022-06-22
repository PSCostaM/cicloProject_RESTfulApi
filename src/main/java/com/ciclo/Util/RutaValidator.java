package com.ciclo.Util;

import com.ciclo.Dto.RutaRequest;
import com.ciclo.Entities.Ruta;
import com.ciclo.exception.IncorrectReportRequestException;

public class RutaValidator {
    public static boolean validateCreate(RutaRequest rutaRequest){
        if(rutaRequest.getUbicacionLlegada() == null || rutaRequest.getUbicacionLlegada().isEmpty() || rutaRequest.getUbicacionLlegada().isBlank())
            throw new IncorrectReportRequestException("Se ha colocado una ubicacion vacia");
        if(rutaRequest.getUbicacionSalida() == null || rutaRequest.getUbicacionSalida().isEmpty() || rutaRequest.getUbicacionSalida().isBlank())
            throw new IncorrectReportRequestException("Se ha colocado una ubicacion vacia");
        return true;
    }
}

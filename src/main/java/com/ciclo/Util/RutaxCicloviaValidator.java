package com.ciclo.Util;

import com.ciclo.Dto.ReportRequest;
import com.ciclo.Dto.RutaxCicloviaRequest;
import com.ciclo.exception.IncorrectReportRequestException;

public class RutaxCicloviaValidator {
    public static boolean validateCreate(String ubicacionSalida,String ubicacionLlegada){
        if(ubicacionSalida == null  || ubicacionSalida.isEmpty() || ubicacionSalida.isBlank() || ubicacionSalida=="")
            throw new IncorrectReportRequestException("Ingrese una ubicacion de Salida");
        if(ubicacionLlegada == null || ubicacionLlegada.isEmpty() || ubicacionLlegada.isBlank() || ubicacionLlegada =="")
            throw new IncorrectReportRequestException("Ingresa una ubicacion de Llegada");
        return true;
    }
}

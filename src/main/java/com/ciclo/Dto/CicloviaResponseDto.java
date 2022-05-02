package com.ciclo.Dto;

import java.util.List;

import lombok.Data;

@Data
public class CicloviaResponseDto {
    Long idCiclovia;
    String nombreCiclovia;
    List<CalificacionResponseDto> calificaciones;
}

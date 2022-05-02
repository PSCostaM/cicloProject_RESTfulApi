package com.ciclo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalificacionRequestDto {
    int estrellasCalificacion;
    String descripcionCalificacion;
    CicloviaResponseDto ciclovia;
}

package com.ciclo.Dto;
import java.util.Date;

import lombok.Data;

@Data
public class CalificacionResponseDto {
    Long idCalificacion;
    Date fechaCalificacion;
    int estrellasCalificacion;
    String descripcionCalificacion;
    CicloviaResponseDto ciclovia;
}

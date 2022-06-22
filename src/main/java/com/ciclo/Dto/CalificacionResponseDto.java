package com.ciclo.Dto;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class CalificacionResponseDto {
    Long idCalificacion;
    Date fechaCalificacion;
    BigDecimal estrellasCalificacion;
    String descripcionCalificacion;
    Long idParking;
}

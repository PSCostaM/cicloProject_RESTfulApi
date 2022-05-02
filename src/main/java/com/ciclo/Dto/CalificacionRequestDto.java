package com.ciclo.Dto;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalificacionRequestDto {
    @NotNull
    int estrellasCalificacion;
    String descripcionCalificacion;
}

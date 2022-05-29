package com.ciclo.Dto;


import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CalificacionRequestDto {
    @NotNull
    int estrellasCalificacion;
    String descripcionCalificacion;
    Long id;
}

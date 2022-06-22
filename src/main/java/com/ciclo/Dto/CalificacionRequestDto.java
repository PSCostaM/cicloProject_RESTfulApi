package com.ciclo.Dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CalificacionRequestDto {
	int estrellasCalificacion;
	String descripcionCalificacion;
}

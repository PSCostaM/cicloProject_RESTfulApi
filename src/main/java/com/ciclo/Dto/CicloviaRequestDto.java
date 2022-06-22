package com.ciclo.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CicloviaRequestDto {
	@NotBlank
	@NotNull
	private String nombreCiclovia;
}

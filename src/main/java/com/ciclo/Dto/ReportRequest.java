package com.ciclo.Dto;


import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class ReportRequest {
	@NotNull
	private String description;
	private long idUser;
}

package com.ciclo.Dto;

import com.ciclo.Entities.User;

import lombok.Data;
import lombok.NonNull;

@Data
public class ReportRequest {
	@NonNull
	private String IdReport;
	@NonNull
	private String dateReport;
	private String description;
	private User idUser;
}

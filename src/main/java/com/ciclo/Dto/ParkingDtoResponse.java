package com.ciclo.Dto;

import lombok.Data;

@Data
public class ParkingDtoResponse {
	String ubicacion;
	int isFull;
	double stars;
	Long id;
}

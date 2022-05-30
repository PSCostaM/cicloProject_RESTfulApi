package com.ciclo.Dto;

import lombok.Data;

@Data
public class ParkingDtoRequest {
	String ubicacion;
	int isFull;
	double stars;
}

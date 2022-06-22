package com.ciclo.Dto;

import lombok.Data;

@Data
public class ParkingDtoResponse {
	String ubicacion;
	boolean full;
	double stars;
	Long id;
}

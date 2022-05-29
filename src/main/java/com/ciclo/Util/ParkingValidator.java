package com.ciclo.Util;

import com.ciclo.Dto.ParkingDto;
import com.ciclo.Entities.Parking;
import com.ciclo.exception.IncorrectReportRequestException;

public class ParkingValidator {
	public static boolean validateCreate(ParkingDto parkingDto) {
		if (parkingDto.getUbicacion() == null)
			throw new IncorrectReportRequestException("Los datos del parking no fueron encontrados");
		return true;
	}

	public static boolean validateGetByParking(Parking parking) {
		if (parking == null)
			throw new IncorrectReportRequestException("El parking no fue encontrado");
		return true;
	}
}

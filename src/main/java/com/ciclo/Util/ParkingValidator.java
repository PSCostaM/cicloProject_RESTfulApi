package com.ciclo.Util;

import com.ciclo.Dto.ParkingDtoRequest;
import com.ciclo.Entities.Parking;
import com.ciclo.exception.IncorrectReportRequestException;

public class ParkingValidator {
	public static boolean validateCreate(ParkingDtoRequest parkingDto) {
		if (parkingDto.getUbicacion() == null)
			throw new IncorrectReportRequestException("Location field is empty");
		return true;
	}

	public static boolean validateGetByParking(Parking parking) {
		if (parking == null)
			throw new IncorrectReportRequestException("El parking no fue encontrado");
		return true;
	}
}

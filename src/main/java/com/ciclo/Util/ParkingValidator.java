package com.ciclo.Util;

import java.util.ArrayList;

import com.ciclo.Dto.ParkingDtoRequest;
import com.ciclo.Entities.Parking;
import com.ciclo.Services.ParkingService;
import com.ciclo.exception.IncorrectReportRequestException;

public class ParkingValidator {
	public static boolean validateCreate(ParkingDtoRequest parkingDto) {
		ArrayList<String> a = new ArrayList<String>(ParkingService.getNames());
		if (parkingDto.getUbicacion() == null)
			throw new IncorrectReportRequestException("Location field is empty");
		else if(a.contains(parkingDto.getUbicacion()))
			throw new IncorrectReportRequestException("El parking ya existe!");
		return true;
	}

	public static boolean validateGetByParking(Parking parking) {
		if (parking == null)
			throw new IncorrectReportRequestException("El parking no fue encontrado");
		return true;
	}
}

package a.com.example.demo.util;

import a.com.example.demo.dto.EstacionamientoRequest;
import a.com.example.demo.exception.IncorrectParkingRequestException;

public class ParkingValidator {
    public static boolean validateParking(EstacionamientoRequest parkingRequest){
        if(parkingRequest.getUbication()==null || parkingRequest.getIdEstacionamiento()==null){
            throw new IncorrectParkingRequestException("Parking Request incorrecto");
        }
        return true;
    }
}

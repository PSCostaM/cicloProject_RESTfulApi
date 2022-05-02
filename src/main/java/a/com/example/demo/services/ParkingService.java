package a.com.example.demo.services;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import a.com.example.demo.dto.EstacionamientoRequest;
import a.com.example.demo.entities.Estacionamiento;
import a.com.example.demo.repository.ParkingRepository;
import a.com.example.demo.util.ParkingValidator;

@Service
public class ParkingService {
    private ParkingRepository parkingRepository;
    public ParkingService(ParkingRepository repository){
        this.parkingRepository = repository;
    }

    @Transactional
    public Estacionamiento createParking(EstacionamientoRequest parkingRequest){
        ParkingValidator.validateParking(parkingRequest);
        Estacionamiento parkingNew = initEstacionamiento(parkingRequest);
        return parkingRepository.save(parkingNew);
    }

    @Transactional(readOnly = true)
    public List<Estacionamiento> getNotFullParking(){
        return parkingRepository.findParking();
    }

    private Estacionamiento initEstacionamiento(EstacionamientoRequest parkingRequest){
        Estacionamiento parkingObj = new Estacionamiento();
        parkingObj.setIdEstacionamiento(UUID.randomUUID().toString());
        parkingObj.setEspacios(parkingRequest.getEspacios());
        parkingObj.setUbication(parkingRequest.getUbication());
        parkingObj.setFlagLleno(parkingRequest.isFlagLleno());
        return parkingObj;
    }
}

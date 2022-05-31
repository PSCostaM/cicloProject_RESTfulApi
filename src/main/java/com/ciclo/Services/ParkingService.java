package com.ciclo.Services;

import java.util.List;

import com.ciclo.Dto.CalificacionRequestDto;
import com.ciclo.Dto.ParkingDtoRequest;
import com.ciclo.Entities.Calificacion;
import com.ciclo.Entities.Parking;
import com.ciclo.Repositories.CalificacionRepository;
import com.ciclo.Repositories.ParkingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ParkingService {
	@Autowired
	private ParkingRepository parkingRepository;
	private CalificacionRepository calificacionRepository;

	public ParkingService(ParkingRepository parkingRepository, CalificacionRepository calificacionRepository) {
        this.parkingRepository = parkingRepository;
        this.calificacionRepository = calificacionRepository;
    }

	// Crear un estacionamiento
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Parking createParking(ParkingDtoRequest parkingDto) {
		Parking parking = new Parking(parkingDto);
		return parkingRepository.save(parking);
	}

	// Calificar el estado de estacionamiento
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public String updateParkingStars(Long parkingId, Long parkingStars) {
		String parkingName = parkingRepository.getById(parkingId).getUbicacion();
		parkingRepository.updateStars(parkingId, parkingStars);
		return String.format("Now %s is %d stars", parkingName, parkingStars);
	}

	// Reportar si un estacionamiento esta full
	public String updateParkingStatus(Long parkingId, int isFull) {
		String parkingName = parkingRepository.getById(parkingId).getUbicacion();
		parkingRepository.updateStatus(parkingId, isFull);
		return String.format("%s full: %d", parkingName, isFull);
	}

	//Listar todos los parkings
	public List<Parking> listAllParkings() {
		return parkingRepository.findAll();
	}

	@Transactional
    public Float getAverageCalificacionById(Long idParking) {
        if(calificacionRepository.getCalificacionesById(idParking).size() == 0) return 0.0f;
        return calificacionRepository.getAverageCalificacionByParkingId(idParking);        
    }

	
	//Encontrar un parking por el número de Id
	@Transactional
	public List<Calificacion> getParkingCalificacionbyId(Long id){
        return calificacionRepository.findCalificacionByParkingId(id);
    }


	//Listar los parkings disponibles
    @Transactional
	public List<Parking> getDisponibilidad(){
        return parkingRepository.findDisponibilidad();
    }

	@Transactional
    public Calificacion createCalificacion(Long id, CalificacionRequestDto calificacionDto) {
        Calificacion calificacion = new Calificacion(getParkingbyId(id), calificacionDto);
        return calificacionRepository.save(calificacion);
    }

	@Transactional(readOnly = true)
    public Parking getParkingbyId(Long id) {
        return parkingRepository.findParkingbyID(id);
    }
}

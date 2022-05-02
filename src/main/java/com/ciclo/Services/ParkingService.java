package com.ciclo.Services;

import java.util.List;

import com.ciclo.Dto.ParkingDto;
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
	public Parking createParking(ParkingDto parkingDto) {
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

	public List<Parking> listAllParkings() {
		return parkingRepository.findAll();
	}

	@Transactional
	public List<Calificacion> getParkingbyId(Long id){
        return calificacionRepository.findCalificacionByParkingId(id);
    }

	@Transactional
	public List<Parking> getDisponibilidad(){
        return parkingRepository.findDisponibilidad();
    }

}

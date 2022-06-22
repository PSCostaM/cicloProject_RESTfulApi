package com.ciclo.Services;

import java.math.BigDecimal;
import java.util.List;

import com.ciclo.Dto.CalificacionRequestDto;
import com.ciclo.Dto.ParkingDto;
import com.ciclo.Entities.Calificacion;
import com.ciclo.Entities.Parking;
import com.ciclo.Repositories.CalificacionRepository;
import com.ciclo.Repositories.ParkingRepository;
import com.ciclo.Util.ParkingValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ParkingService {
	@Autowired
	private static ParkingRepository parkingRepository;
	private CalificacionRepository calificacionRepository;
	private ParkingValidator parkingValidator;

	public ParkingService(ParkingRepository parkingRepository, CalificacionRepository calificacionRepository) {
        this.parkingRepository = parkingRepository;
        this.calificacionRepository = calificacionRepository;
    }

	// Crear un estacionamiento
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
<<<<<<< Updated upstream
	public Parking createParking(ParkingDto parkingDto) {
=======
	public Parking createParking(ParkingDtoRequest parkingDto) {
		parkingValidator.validateCreate(parkingDto);
>>>>>>> Stashed changes
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
	@Transactional
	public String updateParkingStatus(Long parkingId) {
		parkingRepository.updateStatus(parkingId);
		return String.format("");
	}

	@Transactional
	public String updateParkingStars_(Long parkingId) {
		float a=calificacionRepository.getAverageCalificacionByParkingId(parkingId); 
		int b=1;
		a=(float)(((int)(Math.pow(10,b)*a))/Math.pow(10,b)); 
		parkingRepository.updateAvgStars(parkingId, a);
		return String.format("");
	}

	//Listar todos los parkings
	public List<Parking> listAllParkings() {
		return parkingRepository.findAll();
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

	public static List<String> getNames(){
		return parkingRepository.getNames();
	}
}

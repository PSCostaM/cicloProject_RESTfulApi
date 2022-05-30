package com.ciclo.Services;

import java.util.List;

import com.ciclo.Dto.CalificacionRequestDto;
import com.ciclo.Dto.ParkingDtoRequest;
import com.ciclo.Dto.ParkingDtoResponse;
import com.ciclo.Entities.Calificacion;
import com.ciclo.Entities.Parking;
import com.ciclo.Repositories.CalificacionRepository;
import com.ciclo.Repositories.ParkingRepository;
import com.ciclo.Util.CalificacionValidator;
import com.ciclo.Util.EntityDtoConverter;
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
	private ParkingRepository parkingRepository;
	@Autowired
	private CalificacionRepository calificacionRepository;
	@Autowired
	private EntityDtoConverter entityDtoConverter;

	@Transactional(readOnly = true)
	public Parking getParkingById(Long idParking) {
		Parking parking = parkingRepository.getById(idParking);
		ParkingValidator.validateGetByParking(parking);
		return parking;
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

	// Listar todos los parkings
	public List<ParkingDtoResponse> listAllParkings() {
		List<Parking> parkings = parkingRepository.findAll();
		return entityDtoConverter.convertEntityToDto2(parkings);
	}

	// Encontrar un parking por el número de Id
	@Transactional
	public List<Calificacion> getParkingCalificacionbyId(Long id) {
		return calificacionRepository.findCalificacionByParkingId(id);
	}

	// Listar los parkings disponibles
	@Transactional
	public List<Parking> getDisponibilidad() {
		return parkingRepository.findDisponibilidad();
	}

	@Transactional
	public Float getAverageCalificacionById(Long idParking) {
		ParkingValidator.validateGetByParking(parkingRepository.getById(idParking));
		return calificacionRepository.getAverageCalificacionByParkingId(idParking);
	}

	@Transactional
	public Calificacion createCalificacion(Long idParking, CalificacionRequestDto calificacionDto) {
		CalificacionValidator.validateCreate(calificacionDto);
		Parking parking = getParkingById(idParking);
		ParkingValidator.validateGetByParking(parking);
		Calificacion calificacion = new Calificacion(parking, calificacionDto);
		return calificacionRepository.save(calificacion);
	}

	@Transactional(readOnly = true)
	public Parking getParkingbyId(Long id) {
		return parkingRepository.findParkingbyID(id);
	}
}

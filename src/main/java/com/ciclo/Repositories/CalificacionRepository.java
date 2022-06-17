package com.ciclo.Repositories;

import java.util.List;

import com.ciclo.Entities.Calificacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// Postgres no es caps sensitive pero otras DB si lo son.
// Este y los otros repositories no funcionarían en otras DB por esa razon pero que (char)43 (char)48 (char)43 (char)48
//
public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
	@Query("SELECT c FROM Calificacion c WHERE c.idCalificacion = ?1")
	Calificacion findCalificacionByCalificacionId(Long idCalificacion);

	@Query(value = "SELECT * FROM Calificacion INNER JOIN Ciclovia ON Ciclovia.id_Ciclovia = Calificacion.id_Ciclovia WHERE Ciclovia.id_Ciclovia = ?1", nativeQuery = true)
	List<Calificacion> getCalificacionesById(Long idCiclovia);

	@Query(value = "SELECT AVG(Ca.estrellas_calificacion) FROM Calificacion Ca WHERE Ca.id_ciclovia = ?1", nativeQuery = true)
	float getAverageCalificacionByCicloviaId(Long idCiclovia);

	@Query(value = "SELECT AVG(Ca.estrellas_calificacion) FROM Calificacion Ca WHERE Ca.id_parking = ?1", nativeQuery = true)
	float getAverageCalificacionByParkingId(Long idParking);

	@Query(value = "SELECT * FROM Calificacion INNER JOIN Parking ON Calificacion.id_Parking = Parking.id WHERE Calificacion.id_Parking = ?1", nativeQuery = true)
	List<Calificacion> findCalificacionByParkingId(Long id);
}

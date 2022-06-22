package com.ciclo.Repositories;

import java.util.List;

import com.ciclo.Entities.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
    @Query("SELECT c FROM Calificacion c WHERE c.idCalificacion = ?1")
    Calificacion findCalificacionByCalificacionId(Long idCalificacion);

    @Query(
        value = "SELECT * FROM Calificacion INNER JOIN Ciclovia ON Ciclovia.id_Ciclovia = Calificacion.id_Ciclovia WHERE Ciclovia.id_Ciclovia = ?1", nativeQuery = true)
    List<Calificacion> getCalificacionesById(Long idCiclovia);

<<<<<<< Updated upstream
    @Query(
        value = "SELECT AVG(Ca.estrellas_calificacion) FROM Calificacion Ca INNER JOIN Ciclovia Ci ON Ci.id_ciclovia = Ca.id_ciclovia WHERE Ci.id_ciclovia = ?1", nativeQuery = true)
    float getAverageCalificacionById(Long idCiclovia);

    @Query(value = "SELECT * FROM Calificacion INNER JOIN Parking ON Calificacion.id_Parking = Parking.id WHERE Calificacion.id_Parking = ?1", nativeQuery = true)
    List<Calificacion> findCalificacionByParkingId(Long id);
=======
	@Query(value = "SELECT AVG(estrellas_calificacion) FROM Calificacion WHERE id_parking = ?1", nativeQuery = true)
	float getAverageCalificacionByParkingId(Long idParking);

	@Query(value = "SELECT * FROM Calificacion x INNER JOIN Parking y ON x.id_Parking = y.id WHERE x.id_Parking = ?1", nativeQuery = true)
	List<Calificacion> findCalificacionByParkingId(Long id);
>>>>>>> Stashed changes
}


package com.ciclo.Repositories;

import java.util.List;

import com.ciclo.Entities.Calificacion;
import com.ciclo.Entities.Ciclovia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CicloviaRepository extends JpaRepository<Ciclovia, Long> {
	@Query(value = "SELECT calificaciones FROM Ciclovia WHERE id = ?1", nativeQuery = true)
	List<Calificacion> getCalificacionesById(Long idCiclovia);

	@Query(value = "SELECT AVG(Ca.estrellasCalificacion) FROM calificacion Ca INNER JOIN Ciclovia Ci ON Ci.id = Ca.idCiclovia WHERE Ci.id = ?1", nativeQuery = true)
	float getAverageCalificacionById(Long idCiclovia);

	@Query(value = "SELECT Ca FROM calificacion Ca INNER JOIN Ciclovia Ci ON Ci.id = Ca.idCiclovia WHERE Ci.id = ?1 AND Ca.idCalificacion = ?2", nativeQuery = true)
	Calificacion getCalificacionxCicloviaId(Long idCiclovia, Long idCalificacion);
}

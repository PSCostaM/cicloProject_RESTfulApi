package com.ciclo.Repositories;

import com.ciclo.Entities.Ciclovia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CicloviaRepository extends JpaRepository<Ciclovia, Long>{
    @Modifying
	@Query(value = "UPDATE Ciclovia SET calificacionCiclovia = ?2 WHERE id = ?1", nativeQuery = true)
	void updateCalificacion(Long idCiclovia, float calificacion);

    @Query(value = "SELECT calificacionCiclovia FROM Ciclovia WHERE id = ?1", nativeQuery = true)
    float findCalificacionById(Long idCiclovia);
}

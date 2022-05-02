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

    @Query(
        value = "SELECT AVG(Ca.estrellas_calificacion) FROM Calificacion Ca INNER JOIN Ciclovia Ci ON Ci.id_ciclovia = Ca.id_ciclovia WHERE Ci.id_ciclovia = ?1", nativeQuery = true)
    float getAverageCalificacionById(Long idCiclovia);
}


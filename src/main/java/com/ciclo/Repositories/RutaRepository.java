package com.ciclo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ciclo.Entities.Ruta;

import java.util.List;

public interface RutaRepository extends JpaRepository<Ruta, Long> {
    @Query(value = "SELECT r FROM Ruta r WHERE r.idUser = :idUser")
    List<Ruta> getRutasxUser(@Param("idUser") Long idUser);

    @Query(value = "SELECT r FROM Ruta r")
    List<Ruta> getAllRutas();
}

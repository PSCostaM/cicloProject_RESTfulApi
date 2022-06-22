package com.ciclo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ciclo.Entities.RutaxCiclovia;

import java.util.List;

public interface RutaxCicloviaRepository extends JpaRepository<RutaxCiclovia, Long> {
    @Query(value = "SELECT rc FROM RutaxCiclovia rc WHERE rc.idRuta = :idRuta")
    List<RutaxCiclovia> getTiemposByCiclovia(@Param("idRuta") Long idRuta);
}

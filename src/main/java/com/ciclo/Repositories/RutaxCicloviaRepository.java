package com.ciclo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ciclo.Entities.RutaxCiclovia;

import java.util.List;

public interface RutaxCicloviaRepository extends JpaRepository<RutaxCiclovia, Long> {
    @Query(value = "SELECT rc FROM RutaxCiclovia rc WHERE rc.idRuta = :idRuta")
    List<RutaxCiclovia> getTiemposByCiclovia(@Param("idRuta") Long idRuta);
    @Query(value = "SELECT AVG(rc.tiempo_Realizado) FROM RutaX_Ciclovia rc WHERE rc.id_ruta IN (SELECT r.id_Ruta FROM Ruta r WHERE r.ubicacion_Salida = :ubicacionSalida AND r.ubicacion_Llegada = :ubicacionLlegada)",nativeQuery = true)
    Float getTiempoEstimado(@Param("ubicacionSalida")String ubicacionSalida,@Param("ubicacionLlegada")String ubicacionLlegada);
}

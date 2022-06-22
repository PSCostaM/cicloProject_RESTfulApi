package com.ciclo.Repositories;
import com.ciclo.Entities.Ciclovia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CicloviaRepository extends JpaRepository<Ciclovia, Long>{

    @Query("SELECT c FROM Ciclovia c WHERE c.idCiclovia = ?1")
    Ciclovia findCicloviaByCicloviaId(Long idCiclovia);
}

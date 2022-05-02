package a.com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import a.com.example.demo.entities.Calificacion;

public interface CalificacionRepository extends JpaRepository<Calificacion, Long>{
    @Query(value = "SELECT * FROM Calificacion x ORDER BY x.id_estacionamiento", nativeQuery = true)
    List<Calificacion> findBestParkingOrderByCalificacionDesc();
}

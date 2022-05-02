package a.com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import a.com.example.demo.entities.Estacionamiento;

public interface ParkingRepository extends JpaRepository<Estacionamiento, Long> {
    @Query(value = "SELECT * FROM Estacionamiento o WHERE o.flag_lleno = false", nativeQuery = true)
    List<Estacionamiento> findParking();
}
package com.ciclo.Repositories;

import java.util.List;

import com.ciclo.Entities.Parking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {

	@Modifying
	@Query(value = "UPDATE parking SET stars = ?2 WHERE id = ?1", nativeQuery = true)
	void updateStars(Long parkingId, Long parkingStars);

	@Modifying
	@Query(value = "UPDATE parking SET is_full = NOT is_full WHERE id = ?1", nativeQuery = true)
	void updateStatus(Long parkingId);

	@Query(value = "SELECT * FROM Parking x WHERE x.full = 0", nativeQuery = true)
	List<Parking> findDisponibilidad();

	@Query(value = "SELECT * FROM Parking c WHERE c.id = ?1", nativeQuery = true)
    Parking findParkingbyID(Long id);

	@Query(value = "SELECT * FROM Parking c ORDER BY c.stars desc", nativeQuery = true)
	List<Parking> findAll();

	@Modifying
	@Query(value = "UPDATE Parking SET stars = ?2 WHERE id = ?1", nativeQuery = true)
	void updateAvgStars(Long parkingId, float avg);

	@Query(value = "SELECT x.ubicacion FROM Parking x")
	List<String> getNames();
}
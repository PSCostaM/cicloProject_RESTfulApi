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
	@Query(value = "UPDATE parking SET is_full = ?2 WHERE id = ?1", nativeQuery = true)
	void updateStatus(Long parkingId, int isFull);

	@Query(value = "SELECT * FROM Parking x WHERE x.is_full = 0", nativeQuery = true)
	List<Parking> findDisponibilidad();
}

package com.ciclo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ciclo.Dto.ParkingDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parking")
@Data
@NoArgsConstructor
public class Parking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column
	String ubicacion;

	@Column
	int isFull;

	@Column
	double stars;

	public Parking(ParkingDto parkingDto) {
		this.ubicacion = parkingDto.getUbicacion();
		this.isFull = parkingDto.getIsFull();
		this.stars = parkingDto.getStars();
	}
}

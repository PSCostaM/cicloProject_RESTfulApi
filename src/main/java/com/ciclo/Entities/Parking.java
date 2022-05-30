package com.ciclo.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ciclo.Dto.ParkingDtoRequest;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "parking")
@Data
@RequiredArgsConstructor
public class Parking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String ubicacion;

	@Column
	private int isFull;

	@Column
	private double stars;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "ciclovia")
	private List<Calificacion> calificaciones;

	public Parking(ParkingDtoRequest parkingDto) {
		this.ubicacion = parkingDto.getUbicacion();
		this.isFull = parkingDto.getIsFull();
		this.stars = parkingDto.getStars();
		this.calificaciones = new ArrayList<>();
	}
}

package com.ciclo.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.ciclo.Dto.ParkingDto;

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
	private boolean isFull;

	@Column
	private float stars;

<<<<<<< Updated upstream
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "ciclovia")
    private List<Calificacion> calificaciones;
=======
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parking")
	private List<Calificacion> calificaciones;
>>>>>>> Stashed changes

	public Parking(ParkingDto parkingDto) {
		this.ubicacion = parkingDto.getUbicacion();
		this.isFull = false;
		this.stars = 0;
		this.calificaciones = new ArrayList<>();
	}
}

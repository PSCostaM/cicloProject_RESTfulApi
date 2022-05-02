package com.ciclo.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ciclo.Dto.CalificacionRequestDto;

import lombok.Data;

@Data
@Entity
@Table(name = "calificacion")
public class Calificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCalificacion;

	@Column(name = "fechaCalificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCalificacion;

	@Column(name = "estrellasCalificacion")
	private int estrellasCalificacion;

	@Column(name = "descripcionCalificacion")
	private String descripcionCalificacion;

	@ManyToOne
	@JoinColumn(name = "ciclovia_id", nullable = false)
	private Ciclovia ciclovia;

	public Calificacion(Ciclovia ciclovia, CalificacionRequestDto calificacionDto) {
		this.fechaCalificacion = new Date();
		this.estrellasCalificacion = calificacionDto.getEstrellasCalificacion();
		this.descripcionCalificacion = calificacionDto.getDescripcionCalificacion();
		this.ciclovia = ciclovia;
	}
}

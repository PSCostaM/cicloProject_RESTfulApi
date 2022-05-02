package com.ciclo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ciclo.Dto.CicloviaRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Ciclovia")
@NoArgsConstructor
@AllArgsConstructor
public class Ciclovia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCiclovia;

	@Column(name = "nombreCiclovia", length = 50)
	private String nombreCiclovia;

	public Ciclovia(CicloviaRequestDto cicloviaDto) {
		this.nombreCiclovia = cicloviaDto.getNombreCiclovia();
	}
}

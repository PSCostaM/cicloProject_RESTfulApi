package com.ciclo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@Table(name = "Ciclovia")
@Data
@NoArgsConstructor
public class Ciclovia {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCiclovia;

    @Column(name = "calificacionCiclovia")
    private float calificacionCiclovia;
}

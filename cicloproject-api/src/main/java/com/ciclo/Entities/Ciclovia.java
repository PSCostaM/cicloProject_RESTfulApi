package com.ciclo.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ciclo.Dto.CicloviaRequestDto;

import javax.persistence.FetchType;
import javax.persistence.CascadeType;

import lombok.Data;

@Data
@Entity
@Table(name = "Ciclovia")
public class Ciclovia {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCiclovia;

    @Column(name = "nombreCiclovia", length = 50)
    private String nombreCiclovia;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "calificaciones")
    private List<Calificacion> calificaciones;

    public Ciclovia(CicloviaRequestDto cicloviaDto){
        this.nombreCiclovia = cicloviaDto.getNombreCiclovia();
        this.calificaciones = new ArrayList<>();
    }
}

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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.ciclo.Dto.CicloviaRequestDto;

import javax.persistence.FetchType;
import javax.persistence.CascadeType;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Ciclovia")
public class Ciclovia {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCiclovia;

    @Column(name = "nombreCiclovia", length = 50)
    private String nombreCiclovia;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciclovia")
    private List<Calificacion> calificaciones;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciclovia")
    private List<Report> reportes;

    public Ciclovia(CicloviaRequestDto cicloviaDto){
        this.nombreCiclovia = cicloviaDto.getNombreCiclovia();
        this.calificaciones = new ArrayList<>();
    }
}

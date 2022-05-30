package com.ciclo.Entities;
import com.ciclo.Dto.RutaRequest;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.FetchType;
import javax.persistence.CascadeType;
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Ruta")
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRuta;
    @Column(name = "ubicacionSalida")
    private String ubicacionSalida;
    @Column(name = "ubicacionLlegada")
    private String ubicacionLlegada;
    @Column(name = "flagTerminado")
    private boolean flagTerminado;
    @Column(name = "idUser")
    private long idUser;

}

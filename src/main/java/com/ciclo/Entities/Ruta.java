package com.ciclo.Entities;
import lombok.*;
import javax.persistence.*;

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

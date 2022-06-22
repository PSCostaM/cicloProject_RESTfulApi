package com.ciclo.Entities;
import lombok.*;
import javax.persistence.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RutaxCiclovia")
public class RutaxCiclovia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRutaxCiclovia;
    @Column(name = "tiempoRealizado")
    private int tiempoRealizado;
    @Column(name = "idRuta")
    private Long idRuta;
    @Column(name = "idCiclovia")
    private Long idCiclovia;
}

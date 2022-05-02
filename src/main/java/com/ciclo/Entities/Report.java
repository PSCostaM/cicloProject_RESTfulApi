package com.example.demo.entities;

import lombok.*;

import javax.persistence.*;

import com.example.demo.entities.User;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdReport;
    @Column(name = "fechaReporte")
    private String dateReport;
    @Column(name = "descripcionReporte")
    private String description;
    @Column(name = "idUsuario")
    private User idUsuario;
}

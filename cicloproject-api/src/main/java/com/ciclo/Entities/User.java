package com.example.demo.entities;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombreUsuario")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "imagenUsuario")
    private String imageurl;
    @Column(name = "contrasenha")
    private String password;
    @Column(name = "metodoEncriptacion")
    private String cryptmethod;
}

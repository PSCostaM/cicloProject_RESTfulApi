package com.ciclo.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Usuario")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUser;
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

	//@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	//private List<Report> reports;

}

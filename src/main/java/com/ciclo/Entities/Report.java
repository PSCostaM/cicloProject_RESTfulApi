package com.ciclo.Entities;

import javax.persistence.*;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateReport;
	@Column(name = "descripcionReporte")
	private String description;
	@Column(name="idUser")
	private long idUser;
}

package com.TP.IS3.GRUPO3.domain;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="profesor")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@Column(name="apellido", nullable=false)
	private String appelido;
	
	@Column(name="documento", unique=true)
	private long documento;
	
	@Column(name="tipoDoc")
	private String tipoDoc;
}
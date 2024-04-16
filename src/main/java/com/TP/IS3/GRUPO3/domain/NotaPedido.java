package com.TP.IS3.GRUPO3.domain;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="notaPedido")
@Getter @Setter @NoArgsConstructor
public class NotaPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fecha", nullable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fecha;
	
	@Column(name = "turno", nullable=false)
	private char turno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aula_id")
	private Aula aula;
	
	@Column(name = "cantEstudiantes", nullable=false)
	private int cantEstudiantes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "materia_id")
	private Materia materia;
	
	@Column(name = "observaciones", nullable=false)
	private String observaciones;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profesor_id")
	private Profesor profesor;

	@Column(name = "estado")
	private boolean estado;

}

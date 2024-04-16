package com.TP.IS3.GRUPO3.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="espacio")
@Getter @Setter @NoArgsConstructor
public class Espacio {
	
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
	
	@Column(name = "libre")
	private boolean libre;

	public Espacio(int id, LocalDate fecha, char turno, Aula aula, boolean libre) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = libre;
	}

	public Espacio(LocalDate fecha, char turno, Aula aula, boolean libre) {
		super();
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = libre;
	}
	

}

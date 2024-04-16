package com.TP.IS3.GRUPO3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id", name = "idTradicional")
@Table(name="tradicional")
@Getter @Setter @NoArgsConstructor
public class Tradicional extends Aula{

	@Column(name="cantBanco", nullable=false)
	private int cantBanco;
	
	@Column(name="pizarron", nullable=false)
	private String pizarron;
	
	@Column(name="tieneProyector")
	private boolean tieneProyector;
	
}
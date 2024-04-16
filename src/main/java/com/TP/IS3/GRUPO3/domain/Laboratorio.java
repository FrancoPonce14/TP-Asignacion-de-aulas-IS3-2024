package com.TP.IS3.GRUPO3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id", name = "idLaboratorio")
@Table(name="laboratorio")
@Getter @Setter @NoArgsConstructor
public class Laboratorio extends Aula{
	
	@Column(name="cantPc", nullable=false)
	private int cantPc;
	
	@Column(name="cantSilla", nullable=false)
	private int cantSilla;

}
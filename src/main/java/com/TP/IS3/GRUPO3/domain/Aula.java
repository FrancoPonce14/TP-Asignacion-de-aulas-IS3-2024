package com.TP.IS3.GRUPO3.domain;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="aula")
@Getter @Setter @NoArgsConstructor
public class Aula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="numero", nullable=false)
	private int numero;

	private boolean ocupada;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="edificio_id", nullable=true)
	private Edificio edificio;

}
package com.TP.IS3.GRUPO3.domain;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="edificio")
@Data @NoArgsConstructor
public class Edificio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="edificio")
	private Set<Aula> aulas;

}
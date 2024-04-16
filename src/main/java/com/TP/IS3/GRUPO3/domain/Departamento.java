package com.TP.IS3.GRUPO3.domain;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="departamento")
@Data @NoArgsConstructor
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", nullable=false)
	private String nombre;

}
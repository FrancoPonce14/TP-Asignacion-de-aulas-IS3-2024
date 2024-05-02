package com.TP.IS3.GRUPO3.domain;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="materia")
@Data @NoArgsConstructor
public class Materia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "codMateria", nullable=false)
	private int codMateria;
	
	@Column(name = "materia", nullable=false)
	private String nombre;

	private String docente;

	private String turno;

	private String tipoCom;
	
	private String tipoAula; // laboratorio o tradicional
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carrera_id")
	private Carrera carrera;

	@ManyToMany(mappedBy = "materias", fetch = FetchType.LAZY)
	private List<Estudiante> estudiantes;
	

}

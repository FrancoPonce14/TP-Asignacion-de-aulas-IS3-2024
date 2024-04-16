package com.TP.IS3.GRUPO3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="perfil")
@Data @NoArgsConstructor
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerfil;
	
	@Column(name="nombre", unique=true, nullable=false, length=50)
	private String nombre;
	
	@Column(name="habilitado", nullable=false)
	private boolean habilitado;

	public Perfil(int idPerfil, String nombre, boolean habilitado) {
		super();
		this.nombre = nombre;
		this.idPerfil = idPerfil;
		this.habilitado = habilitado;
	}
	
}
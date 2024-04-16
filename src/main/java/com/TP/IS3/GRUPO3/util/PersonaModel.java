package com.TP.IS3.GRUPO3.util;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class PersonaModel {
	
	private int idPersona;
	@NotNull
	private String nombre;
	@NotNull
	private String apellido;
	@NotNull
	private long documento;
	
	public PersonaModel(int idPersona, String nombre, String apellido, long documento) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
	}

}

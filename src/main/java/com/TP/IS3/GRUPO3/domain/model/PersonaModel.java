package com.TP.IS3.GRUPO3.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class PersonaModel {
	
	private int idPersona;
	private String nombre;
	private String apellido;
	private long documento;
	
}

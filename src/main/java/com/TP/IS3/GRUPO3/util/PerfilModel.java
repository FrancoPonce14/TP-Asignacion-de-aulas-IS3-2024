package com.TP.IS3.GRUPO3.util;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor
public class PerfilModel {
	
	private int idPerfil;
	private String nombre;
	private boolean habilitado;

	public PerfilModel(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public PerfilModel(int idPerfil, String nombre, boolean habilitado) {
		super();
		this.nombre = nombre;
		this.idPerfil = idPerfil;
		this.habilitado = habilitado;
	}

}

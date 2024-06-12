package com.TP.IS3.GRUPO3.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
public class PerfilModel {
	
	private int idPerfil;
	private String nombre;
	private boolean habilitado;

}

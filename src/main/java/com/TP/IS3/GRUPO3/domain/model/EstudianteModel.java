package com.TP.IS3.GRUPO3.domain.model;


import com.TP.IS3.GRUPO3.domain.Perfil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class EstudianteModel {
	
	private int idUsuario;
	private String nombre;
	private String apellido;
	private String tipoDoc;
	private long documento;
	private String email;
	private String nombreUsuario;
	private String clave;
	private Perfil perfil;
	private int idPerfil;

}
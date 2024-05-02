package com.TP.IS3.GRUPO3.util;


import com.TP.IS3.GRUPO3.domain.Perfil;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
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


	public EstudianteModel(int idUsuario, String nombre, String apellido, String tipoDoc, long documento, String email,
			String nombreUsuario, String clave, Perfil perfil) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDoc = tipoDoc;
		this.documento = documento;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.perfil = perfil;
	}



}
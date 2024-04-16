package com.TP.IS3.GRUPO3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuario")
@Data @NoArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@Column(name="apellido", nullable=false)
	private String apellido;
	
	@Column(name="tipoDoc", nullable=false, length=5)
	private String tipoDoc;
	
	@Column(name="documento", unique=true, nullable=false, length=45)
	private long documento;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="nombreUsuario", unique=true, nullable=false, length=45)
	private String nombreUsuario;
	
	@Column(name="clave", nullable=false, length=60)
	private String clave;
	
	@Column(name="habilitado")
	private boolean habilitado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_perfil", nullable=false)
	private Perfil perfil;


	public Usuario(int idUsuario, String nombre, String apellido, String tipoDoc, long documento, String email,
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
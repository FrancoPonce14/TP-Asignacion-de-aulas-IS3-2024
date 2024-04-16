package com.TP.IS3.GRUPO3.services;

import java.util.List;

import com.TP.IS3.GRUPO3.domain.Usuario;
import com.TP.IS3.GRUPO3.util.UsuarioModel;

public interface IUsuarioService {

	public List<Usuario> findAll();
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel);
	public boolean remove(int id);
	UsuarioModel findById(int id);
	UsuarioModel findByNombreUsuario(String nombreUsuario);
	public List<Usuario> findByIdPerfil(int idPerfil);
}

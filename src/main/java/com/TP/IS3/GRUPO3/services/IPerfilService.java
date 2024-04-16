package com.TP.IS3.GRUPO3.services;

import java.util.List;

import com.TP.IS3.GRUPO3.domain.Perfil;
import com.TP.IS3.GRUPO3.util.PerfilModel;

public interface IPerfilService {

	public List<Perfil> findAll();
	public PerfilModel insertOrUpdate(PerfilModel PerfilModel);
	public boolean remove(int id);
	PerfilModel findById(int id);
	PerfilModel findByNombrePerfil(String nombrePerfil);
	public abstract List<Perfil> getPerfilesHabilitados();
}

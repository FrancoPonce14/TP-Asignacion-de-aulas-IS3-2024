package com.TP.IS3.GRUPO3.services;

import java.util.List;

import com.TP.IS3.GRUPO3.domain.Materia;
import com.TP.IS3.GRUPO3.domain.Usuario;

public interface IMateriaService {

	public List<Materia> getAll();
	public boolean insertOrUpdate(Materia materia);
	public Materia findById(int id);
	public boolean remove(int id);
	public List<Usuario> traerUsuariosByMateriaId(int idMateria);
}


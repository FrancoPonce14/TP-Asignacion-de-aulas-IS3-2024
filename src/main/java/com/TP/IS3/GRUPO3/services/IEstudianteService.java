package com.TP.IS3.GRUPO3.services;

import java.util.List;

import com.TP.IS3.GRUPO3.domain.Estudiante;
import com.TP.IS3.GRUPO3.util.EstudianteModel;

public interface IEstudianteService {

	public List<Estudiante> findAll();
	public EstudianteModel insertOrUpdate(EstudianteModel usuarioModel);
	public boolean remove(int id);
	EstudianteModel findById(int id);
	EstudianteModel findByNombreUsuario(String nombreUsuario);
	public List<Estudiante> findByIdPerfil(int idPerfil);
}

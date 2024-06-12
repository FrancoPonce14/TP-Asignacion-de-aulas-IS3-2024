package com.TP.IS3.GRUPO3.services;

import java.util.List;

import com.TP.IS3.GRUPO3.domain.Docente;

public interface IDocenteService {

	public List<Docente> getAll();
	public boolean insertOrUpdate(Docente docente);
	public Docente findById(int id);
	public boolean remove(int id);
}
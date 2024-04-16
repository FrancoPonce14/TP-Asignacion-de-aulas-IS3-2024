package com.TP.IS3.GRUPO3.services;

import java.util.List;

import com.TP.IS3.GRUPO3.domain.Profesor;

public interface IProfesorService {

	public List<Profesor> getAll();
	public boolean insertOrUpdate(Profesor profesor);
	public Profesor findById(int id);
	public boolean remove(int id);
}
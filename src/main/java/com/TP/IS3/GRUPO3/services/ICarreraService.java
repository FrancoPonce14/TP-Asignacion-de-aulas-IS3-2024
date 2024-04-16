package com.TP.IS3.GRUPO3.services;

import java.util.List;

import com.TP.IS3.GRUPO3.domain.Carrera;

public interface ICarreraService {

	public List<Carrera> getAll();
	public boolean insertOrUpdate(Carrera carrera);
	public Carrera findById(int id);
	public boolean remove(int id);
}

package com.TP.IS3.GRUPO3.services;

import java.util.List;

import com.TP.IS3.GRUPO3.domain.Edificio;

public interface IEdificioService {
	
	public List<Edificio> getAll();
	public boolean insertOrUpdate(Edificio edificio);
	public Edificio findById(int id);
	public boolean remove(int id);
	public Edificio traerEdificioConAulas(int idEdificio);
}

package com.TP.IS3.GRUPO3.services;

import java.util.List;

import com.TP.IS3.GRUPO3.domain.Departamento;

public interface IDepartamentoService {

	public List<Departamento> getAll();
	public boolean insertOrUpdate(Departamento departamento);
	public Departamento findById(int id);
	public boolean remove(int id);
}
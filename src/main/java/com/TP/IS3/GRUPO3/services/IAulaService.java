package com.TP.IS3.GRUPO3.services;

import java.util.List;

import com.TP.IS3.GRUPO3.domain.Aula;
import com.TP.IS3.GRUPO3.domain.Laboratorio;
import com.TP.IS3.GRUPO3.domain.Tradicional;

public interface IAulaService {
	
	public List<Aula> getAll();
	public boolean insertOrUpdate(Aula aula);
	public Aula findById(int id);
	public boolean remove(int id);
	public List<Tradicional> getAllTradicional();
	public List<Laboratorio> getAllLaboratorio();
	public List<Tradicional> getAllTradicionalID(int id);
	public List<Laboratorio> getAllLaboratorioID(int id);

}

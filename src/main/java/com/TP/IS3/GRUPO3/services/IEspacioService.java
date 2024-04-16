package com.TP.IS3.GRUPO3.services;

import java.time.LocalDate;
import java.util.List;

import com.TP.IS3.GRUPO3.domain.Aula;
import com.TP.IS3.GRUPO3.domain.Espacio;

public interface IEspacioService {

	public List<Espacio> getAll();
	public boolean insertOrUpdate(Espacio espacio);
	public Espacio findById(int id);
	public boolean remove(int id);
	public Espacio traer(LocalDate fecha, char turno, Aula aula);
	public boolean agregar(LocalDate fecha, char turno, Aula aula, boolean libre) throws Exception;
	public void agregarEspacioMes(int mes, int anio, char turno, Aula aula) throws Exception;
}

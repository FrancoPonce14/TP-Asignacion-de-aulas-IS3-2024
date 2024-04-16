package com.TP.IS3.GRUPO3.services;

import java.util.List;

import com.TP.IS3.GRUPO3.domain.NotaPedido;

public interface INotaPedidoService {
	
	public List<NotaPedido> getAll();
	public boolean insertOrUpdate(NotaPedido notaPedido);
	public NotaPedido findById(int id);
	public boolean remove(int id);
}
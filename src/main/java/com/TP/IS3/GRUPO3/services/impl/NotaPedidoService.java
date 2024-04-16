package com.TP.IS3.GRUPO3.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.IS3.GRUPO3.domain.NotaPedido;
import com.TP.IS3.GRUPO3.repositorys.INotaPedidoRepository;
import com.TP.IS3.GRUPO3.services.INotaPedidoService;

@Service
public class NotaPedidoService implements INotaPedidoService {

    @Autowired
    private INotaPedidoRepository notaPedidoRepository;

    @Override
    public List<NotaPedido> getAll() {
        return notaPedidoRepository.findAll();
    }

    @Override
    public boolean insertOrUpdate(NotaPedido notaPedido) {
        try {
            notaPedidoRepository.save(notaPedido);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public NotaPedido findById(int id) {
        return notaPedidoRepository.findById(id).orElse(null);
    }

    @Override
    public boolean remove(int id) {
        try {
            notaPedidoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
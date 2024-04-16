package com.TP.IS3.GRUPO3.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.IS3.GRUPO3.domain.Departamento;
import com.TP.IS3.GRUPO3.repositorys.IDepartamentoRepository;
import com.TP.IS3.GRUPO3.services.IDepartamentoService;

@Service
public class DepartamentoService implements IDepartamentoService {

    @Autowired
    private IDepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> getAll() {
        return departamentoRepository.findAll();
    }

    @Override
    public boolean insertOrUpdate(Departamento departamento) {
        try {
            departamentoRepository.save(departamento);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Departamento findById(int id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    @Override
    public boolean remove(int id) {
        try {
            departamentoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

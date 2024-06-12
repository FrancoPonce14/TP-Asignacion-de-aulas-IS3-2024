package com.TP.IS3.GRUPO3.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.IS3.GRUPO3.domain.Docente;
import com.TP.IS3.GRUPO3.repositorys.IDocenteRepository;
import com.TP.IS3.GRUPO3.services.IDocenteService;

@Service
public class DocenteService implements IDocenteService {

    @Autowired
    private IDocenteRepository docenteRepository;

    @Override
    public List<Docente> getAll() {
        return docenteRepository.findAll();
    }

    @Override
    public boolean insertOrUpdate(Docente docente) {
        try {
            docenteRepository.save(docente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Docente findById(int id) {
        return docenteRepository.findById(id).orElse(null);
    }

    @Override
    public boolean remove(int id) {
        try {
            docenteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
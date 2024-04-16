package com.TP.IS3.GRUPO3.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.IS3.GRUPO3.domain.Aula;
import com.TP.IS3.GRUPO3.domain.Laboratorio;
import com.TP.IS3.GRUPO3.domain.Tradicional;
import com.TP.IS3.GRUPO3.repositorys.IAulaRepository;
import com.TP.IS3.GRUPO3.services.IAulaService;

@Service
public class AulaService implements IAulaService {

    @Autowired
    private IAulaRepository aulaRepository;

    @Override
    public List<Aula> getAll() {
        return aulaRepository.findAll();
    }

    @Override
    public boolean insertOrUpdate(Aula aula) {
        try {
            aulaRepository.save(aula);
            return true;
        } catch (Exception he) {
            return false;
        }
    }

    @Override
    public Aula findById(int id) {
        return aulaRepository.findById(id).orElse(null);
    }

    @Override
    public boolean remove(int id) {
        try {
            aulaRepository.deleteById(id);
            return true;
        } catch (Exception he) {
            return false;
        }
    }

    @Override
    public List<Tradicional> getAllTradicional() {
        return aulaRepository.getTradicional();
    }

    @Override
    public List<Laboratorio> getAllLaboratorio() {
        return aulaRepository.getLaboratorio();
    }

    @Override
    public List<Tradicional> getAllTradicionalID(int id) {
        return aulaRepository.getAllTradicionalID(id);
    }

    @Override
    public List<Laboratorio> getAllLaboratorioID(int id) {
        return aulaRepository.getAllLaboratorioID(id);
    }

}
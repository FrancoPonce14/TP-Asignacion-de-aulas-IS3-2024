package com.TP.IS3.GRUPO3.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.IS3.GRUPO3.domain.Edificio;
import com.TP.IS3.GRUPO3.repositorys.IEdificioRepository;
import com.TP.IS3.GRUPO3.services.IEdificioService;

@Service
public class EdificioService implements IEdificioService {

    @Autowired
    private IEdificioRepository edificioRepository;

    @Override
    public List<Edificio> getAll() {
        return edificioRepository.findAll();
    }

    @Override
    public boolean insertOrUpdate(Edificio edificio) {
        try {
            edificioRepository.save(edificio);
            return true;
        } catch (Exception he) {
            return false;
        }
    }

    @Override
    public Edificio findById(int id) {
        return edificioRepository.findById(id).orElse(null);
    }

    @Override
    public boolean remove(int id) {
        try {
            edificioRepository.deleteById(id);
            return true;
        } catch (Exception he) {
            return false;
        }
    }

    @Override
    public Edificio traerEdificioConAulas(int idEdificio) {
        return edificioRepository.traerEdificioConAulas(idEdificio);
    }
}
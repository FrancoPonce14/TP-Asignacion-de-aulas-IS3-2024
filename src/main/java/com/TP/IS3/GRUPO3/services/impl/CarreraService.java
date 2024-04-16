package com.TP.IS3.GRUPO3.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.IS3.GRUPO3.domain.Carrera;
import com.TP.IS3.GRUPO3.repositorys.ICarreraRepository;
import com.TP.IS3.GRUPO3.services.ICarreraService;

@Service
public class CarreraService implements ICarreraService {

    @Autowired
    private ICarreraRepository carreraRepository;

    @Override
    public List<Carrera> getAll() {
        return carreraRepository.findAll();
    }

    @Override
    public boolean insertOrUpdate(Carrera carrera) {
        try {
            carreraRepository.save(carrera);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Carrera findById(int id) {
        return carreraRepository.findById(id).orElse(null);
    }

    @Override
    public boolean remove(int id) {
        try {
            carreraRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
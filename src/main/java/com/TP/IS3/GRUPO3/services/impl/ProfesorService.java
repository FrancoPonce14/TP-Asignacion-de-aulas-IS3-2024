package com.TP.IS3.GRUPO3.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.IS3.GRUPO3.domain.Profesor;
import com.TP.IS3.GRUPO3.repositorys.IProfesorRepository;
import com.TP.IS3.GRUPO3.services.IProfesorService;

@Service
public class ProfesorService implements IProfesorService {

    @Autowired
    private IProfesorRepository profesorRepository;

    @Override
    public List<Profesor> getAll() {
        return profesorRepository.findAll();
    }

    @Override
    public boolean insertOrUpdate(Profesor profesor) {
        try {
            profesorRepository.save(profesor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Profesor findById(int id) {
        return profesorRepository.findById(id).orElse(null);
    }

    @Override
    public boolean remove(int id) {
        try {
            profesorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
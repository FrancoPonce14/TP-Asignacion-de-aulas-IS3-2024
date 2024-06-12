package com.TP.IS3.GRUPO3.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.IS3.GRUPO3.domain.Perfil;
import com.TP.IS3.GRUPO3.domain.model.PerfilModel;
import com.TP.IS3.GRUPO3.repositorys.IPerfilRepository;
import com.TP.IS3.GRUPO3.services.IPerfilService;

@Service
public class PerfilService implements IPerfilService {

    @Autowired
    private IPerfilRepository perfilRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<Perfil> findAll() {
        return perfilRepository.findAll();
    }

    @Override
    public PerfilModel findById(int id) {
        return modelMapper.map(perfilRepository.findById(id), PerfilModel.class);
    }

    @Override
    public PerfilModel findByNombrePerfil(String nombrePerfil) {
        return modelMapper.map(perfilRepository.findByNombre(nombrePerfil), PerfilModel.class);
    }

    @Override
    public PerfilModel insertOrUpdate(PerfilModel PerfilModel) {
        Perfil perfil = perfilRepository.save(modelMapper.map(PerfilModel, Perfil.class));
        return modelMapper.map(perfil, PerfilModel.class);
    }

    @Override
    public boolean remove(int id) {
        try {
            perfilRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Perfil> getPerfilesHabilitados() {
        return perfilRepository.getPerfilesHabilitados();
    }
}

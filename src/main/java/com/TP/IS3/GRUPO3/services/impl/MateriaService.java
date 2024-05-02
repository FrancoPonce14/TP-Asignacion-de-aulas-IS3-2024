package com.TP.IS3.GRUPO3.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.IS3.GRUPO3.domain.Estudiante;
import com.TP.IS3.GRUPO3.domain.Materia;
import com.TP.IS3.GRUPO3.repositorys.IMateriaRepository;
import com.TP.IS3.GRUPO3.services.IMateriaService;

@Service
public class MateriaService implements IMateriaService {
	
	@Autowired
	private IMateriaRepository materiaRepository;
	
	@Override
	public List<Materia> getAll() {
		return materiaRepository.findAll();
	}

	@Override
	public boolean insertOrUpdate(Materia materia) {
		try {
			materiaRepository.save(materia);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public Materia findById(int id) {
		return materiaRepository.findById(id).orElse(null);
	}

	@Override
	public boolean remove(int id) {
		try {
			materiaRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<Estudiante> getEstudiantesByMateriaId(int idMateria) {
		Materia materia = materiaRepository.findById(idMateria).orElse(null);
		return materia.getEstudiantes();
	}

}
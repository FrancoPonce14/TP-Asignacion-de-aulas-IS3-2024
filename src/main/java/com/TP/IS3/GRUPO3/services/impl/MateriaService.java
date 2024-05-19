package com.TP.IS3.GRUPO3.services.impl;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TP.IS3.GRUPO3.domain.Aula;
import com.TP.IS3.GRUPO3.domain.Estudiante;
import com.TP.IS3.GRUPO3.domain.Laboratorio;
import com.TP.IS3.GRUPO3.domain.Materia;
import com.TP.IS3.GRUPO3.domain.Tradicional;
import com.TP.IS3.GRUPO3.repositorys.IMateriaRepository;
import com.TP.IS3.GRUPO3.services.IAulaService;
import com.TP.IS3.GRUPO3.services.IMateriaService;

@Service
public class MateriaService implements IMateriaService {

	@Autowired
	private IMateriaRepository materiaRepository;

	@Autowired
	private IAulaService aulaService;

	@Override
	public List<Materia> getAll() {
		return materiaRepository.findAll();
	}

	@Override
	public boolean insertOrUpdate(Materia materia) {
		try {
			materiaRepository.save(materia);
			return true;
		} catch (Exception e) {
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
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Estudiante> getEstudiantesByMateriaId(int idMateria) {
		Materia materia = materiaRepository.findById(idMateria).orElse(null);
		return materia.getEstudiantes();
	}

	@Override
	public void asignarAulas() {
		// Primero - me traigo todas las materias y todas las aulas
		List<Materia> materias = materiaRepository.findAll();
		List<Laboratorio> laboratorios = aulaService.getAllLaboratorio();
		List<Tradicional> tradicionales = aulaService.getAllTradicional();

		// Segundo - recorro todas las materias y me fijo si ya tienen aulas o todavia no
		// si no tiene, entonces, me fijo que tipo de aula necesita esa materia "Laboratorio" o "Tradicional"
		for (Materia materia : materias) {
			if (materia.getAulas().isEmpty()) {
				String tipoAula = materia.getTipoAula();
				List<? extends Aula> aulasDisponibles = tipoAula.equalsIgnoreCase("laboratorio") ? laboratorios
						: tradicionales;

				// Tercero - ordeno las aulas disponibles para una mejor asignacion
				aulasDisponibles.sort(Comparator.comparingInt(aula -> getCapacidadAula(aula)));

				// Cuarto - recorro las ordenadas y me fijo que no este ocupada y que tenga espacio para los estudiantes requeridos
				for (Aula aula : aulasDisponibles) {
					if (!aula.isOcupada() && getCapacidadAula(aula) >= materia.getEstudiantes().size()) {
						materia.getAulas().add(aula);
						aula.setOcupada(true);
						materiaRepository.save(materia);
						break;
					}
				}
				//PARA LA ENTREGA FINAL LO IDEAL SERIA MEJORAR ESTE METODO PARA QUE 
				/*
				 * 1- asigne mas de 1 aula a una materia (ya que ahora solo asigna 1
				 * 2- optimizar
				 */
			}
		}
	}

	private int getCapacidadAula(Aula aula) {
		if (aula instanceof Laboratorio) {
			return ((Laboratorio) aula).getCantPc();
		} else if (aula instanceof Tradicional) {
			return ((Tradicional) aula).getCantBanco();
		}
		return 0;
	}

}
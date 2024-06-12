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

		for (Materia materia : materias) {
			if (materia.getAulas().isEmpty()) {
				String tipoAula = materia.getTipoAula();
				List<? extends Aula> aulasDisponibles = tipoAula.equalsIgnoreCase("laboratorio") ? laboratorios
						: tradicionales;

				aulasDisponibles.sort(Comparator.comparingInt(aula -> getCapacidadAula(aula)));
				int cantidadEstudiantes = materia.getEstudiantes().size();
				int siguienteAula = 0;
				// Mientras la materia siga teniendo estudiantes y haya aulas disponibles se
				// sigue asignando
				while (cantidadEstudiantes > 0 && siguienteAula < aulasDisponibles.size()) {
					Aula aula = aulasDisponibles.get(siguienteAula);
					if (!aula.isOcupada()) {
						int capacidadAula = getCapacidadAula(aula);
						// Calculo cuantos estudiantes se asignan en el aula seleccionada arriba - se
						// asignan los estudiantes
						int estudiantesAsignar = Math.min(capacidadAula, cantidadEstudiantes);
						materia.getAulas().add(aula);
						aula.setOcupada(true);
						// Al total de estudiantes de la materia le resto los estudiantes asginados <- y
						// los que quedan los vuelve a asignar a otra aula
						cantidadEstudiantes = cantidadEstudiantes - estudiantesAsignar;
						materiaRepository.save(materia);
					}
					// Indice para pasar a la siguiente aula
					siguienteAula++;
				}
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
package com.TP.IS3.GRUPO3.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TP.IS3.GRUPO3.domain.Aula;
import com.TP.IS3.GRUPO3.domain.Laboratorio;
import com.TP.IS3.GRUPO3.domain.Tradicional;

public interface IAulaRepository extends JpaRepository<Aula, Integer> {
	
	@Query(value = "SELECT * FROM aula INNER JOIN laboratorio ON aula.id = laboratorio.id_laboratorio",nativeQuery=true)
	public abstract List<Laboratorio> getLaboratorio();
	@Query(value = "SELECT * FROM aula INNER JOIN tradicional ON aula.id = tradicional.id_tradicional",nativeQuery=true)
	public abstract List<Tradicional> getTradicional();
	
	@Query(value = "SELECT * FROM aula INNER JOIN laboratorio ON aula.id = laboratorio.id_laboratorio"+"where laboratorio.id_laboratorio=:idLaboratorio",nativeQuery=true)
	public abstract List<Laboratorio> getAllLaboratorioID(int idLaboratorio);
	@Query(value = "SELECT * FROM aula INNER JOIN tradicional ON aula.id = tradicional.id_tradicional"+"where tradicional.id_tradicional=:idTradicional",nativeQuery=true)
	public abstract List<Tradicional> getAllTradicionalID(int idTradicional);
	

}
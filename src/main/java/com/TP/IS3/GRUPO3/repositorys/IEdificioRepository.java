package com.TP.IS3.GRUPO3.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TP.IS3.GRUPO3.domain.Edificio;

public interface IEdificioRepository extends JpaRepository<Edificio, Integer>{
	
	@Query(value = "SELECT * FROM edificio e INNER JOIN aula a ON e.id = a.edificio_id "+"where a.edificio_id=:idEdificio",nativeQuery=true)
	public abstract Edificio traerEdificioConAulas(int idEdificio);


}

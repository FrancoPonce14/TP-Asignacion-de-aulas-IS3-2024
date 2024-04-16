package com.TP.IS3.GRUPO3.repositorys;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.TP.IS3.GRUPO3.domain.Perfil;

@Repository("perfilRepository")
public interface IPerfilRepository extends JpaRepository<Perfil, Serializable> {

	public abstract Perfil findByIdPerfil(int idPerfil);
	public abstract Perfil findByNombre(String nombre);
	@Query(value = "select * from perfil where habilitado = 1;",nativeQuery=true)
	public abstract List<Perfil> getPerfilesHabilitados();
	
}
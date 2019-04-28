package com.tindora.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tindora.model.entities.UsuarioRol;

@Repository
public interface UsuarioRolRepository 
extends JpaRepository<UsuarioRol, Integer> {
	//Transaction 
		@Modifying
		//DML:insert, update o delete
		@Query(value="INSERT INTO usuario_rol(usuario_id,rol_id) "
				+ "VALUES(:usuarioId,:rolId) ",nativeQuery=true)
		Integer registrar (@Param("usuarioId") Integer usuarioId,
				@Param("rolId") Integer rolId);
}

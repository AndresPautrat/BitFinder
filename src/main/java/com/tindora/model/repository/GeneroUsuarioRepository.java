package com.tindora.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tindora.model.entities.GeneroUsuario;

@Repository
public interface GeneroUsuarioRepository
extends JpaRepository<GeneroUsuario, Integer>{

	//Transaction 
		@Modifying
		@Transactional
		//DML:insert, update o delete
		@Query(value="INSERT INTO genero_usuario(usuario_id,genero_id) "
				+ "VALUES(:usuarioId,:generoId) ",nativeQuery=true)
		Integer registrar (@Param("usuarioId") Integer usuarioId,
				@Param("generoId") Integer generoId);
	
	
}

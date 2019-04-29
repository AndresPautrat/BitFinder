package com.tindora.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tindora.model.entities.ArtistaUsuario;

@Repository
public interface ArtistaUsuarioRepository 
extends JpaRepository<ArtistaUsuario, Integer>{

	//Transaction 
		@Modifying
		@Transactional
		//DML:insert, update o delete
		@Query(value="INSERT INTO artista_usuario(usuario_id,artista_id) "
				+ "VALUES(:usuarioId,:artistaId) ",nativeQuery=true)
		Integer registrar (@Param("usuarioId") Integer usuarioId,
				@Param("artistaId") Integer artistaId);
	
}

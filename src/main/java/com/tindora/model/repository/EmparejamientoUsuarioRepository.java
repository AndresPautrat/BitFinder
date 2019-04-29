package com.tindora.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tindora.model.entities.EmparejamientoUsuario;

@Repository
public interface EmparejamientoUsuarioRepository 
extends JpaRepository<EmparejamientoUsuario, Integer>{

	
	//Transaction 
		@Modifying
		@Transactional
		//DML:insert, update o delete
		@Query(value="INSERT INTO emparejamiento_usuario(usuario_id,emparejamiento_id) "
				+ "VALUES(:usuarioId,:emparejamientoId) ",nativeQuery=true)
		Integer registrar (@Param("usuarioId") Integer usuarioId,
				@Param("emparejamientoId") Integer emparejamientoId);
}

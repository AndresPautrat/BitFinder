package com.tindora.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tindora.model.entities.UsuarioPlaylist;

@Repository
public interface UsuarioPlaylistRepository
extends JpaRepository<UsuarioPlaylist, Integer>{

	//Transaction 
		@Modifying
		//DML:insert, update o delete
		@Query(value="INSERT INTO usuario_playlist(usuario_Id,playlist_id) "
				+ "VALUES(:usuarioId,:playlistId) ",nativeQuery=true)
		Integer registrar (@Param("usuarioId") Integer usuarioId,
				@Param("playlistId") Integer playlistId);
	
	
}

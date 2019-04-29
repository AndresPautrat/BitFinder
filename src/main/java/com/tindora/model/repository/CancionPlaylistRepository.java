package com.tindora.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tindora.model.entities.CancionPlaylist;
@Repository
public interface CancionPlaylistRepository 
extends JpaRepository<CancionPlaylist, Integer>{

	//Transaction 
			@Modifying
			@Transactional
			//DML:insert, update o delete
			@Query(value="INSERT INTO cancion_playlist(cancion_id,playlist_id) "
					+ "VALUES(:cancionId,:playlistId) ",nativeQuery=true)
			Integer registrar (@Param("cancionId") Integer cancionId,
					@Param("playlistId") Integer playlistId);
			
}

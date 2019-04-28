package com.tindora.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tindora.model.entities.Playlist;

@Repository
public interface PlaylistRepository  extends JpaRepository<Playlist, Integer>{

}

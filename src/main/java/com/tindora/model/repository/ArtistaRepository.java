package com.tindora.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tindora.model.entities.Artista;

@Repository
public interface ArtistaRepository 
extends JpaRepository<Artista, Integer>{

}

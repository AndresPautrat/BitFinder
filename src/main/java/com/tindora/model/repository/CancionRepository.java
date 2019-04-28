package com.tindora.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tindora.model.entities.Cancion;

@Repository
public interface CancionRepository extends 
JpaRepository<Cancion, Integer>{

}

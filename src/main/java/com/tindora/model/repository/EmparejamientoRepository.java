package com.tindora.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tindora.model.entities.Emparejamiento;
@Repository
public interface EmparejamientoRepository 
extends JpaRepository<Emparejamiento, Integer> {

}

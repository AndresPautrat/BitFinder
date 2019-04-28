package com.tindora.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tindora.model.entities.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {

}

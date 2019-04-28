package com.tindora.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tindora.model.entities.Cancion;
import com.tindora.model.repository.CancionRepository;
import com.tindora.service.CancionService;

@Service
public class CancionServiceImpl implements CancionService{

	@Autowired
	CancionRepository cancionRepository;
	
	@Override
	public Cancion registrar(Cancion t) {
		// TODO Auto-generated method stub
		return cancionRepository.save(t);
	}

	@Override
	public Cancion modificar(Cancion t) {
		// TODO Auto-generated method stub
		return cancionRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		cancionRepository.deleteById(id);
	}

	@Override
	public List<Cancion> listar() {
		// TODO Auto-generated method stub
		return cancionRepository.findAll();
	}

	@Override
	public Optional<Cancion> listID(int id) {
		// TODO Auto-generated method stub
		return cancionRepository.findById(id);
	}

	
}

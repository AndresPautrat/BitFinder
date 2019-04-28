package com.tindora.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tindora.model.entities.Artista;
import com.tindora.model.repository.ArtistaRepository;
import com.tindora.service.ArtistaService;

@Service
public class ArtistaServiceImpl implements ArtistaService{

	@Autowired
	ArtistaRepository artistaRepository;

	@Override
	public Artista registrar(Artista t) {
		// TODO Auto-generated method stub
		return artistaRepository.save(t);
	}

	@Override
	public Artista modificar(Artista t) {
		// TODO Auto-generated method stub
		return artistaRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		artistaRepository.deleteById(id);
	}

	@Override
	public List<Artista> listar() {
		// TODO Auto-generated method stub
		return artistaRepository.findAll();
	}

	@Override
	public Optional<Artista> listID(int id) {
		// TODO Auto-generated method stub
		return artistaRepository.findById(id);
	}
	
	
}

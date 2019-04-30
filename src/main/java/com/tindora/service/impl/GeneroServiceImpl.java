package com.tindora.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tindora.model.entities.Genero;
import com.tindora.model.repository.GeneroRepository;
import com.tindora.service.GeneroService;
@Service
public class GeneroServiceImpl implements GeneroService{

	@Autowired 
	GeneroRepository generoRepository;
	
	@Override
	public Genero registrar(Genero t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genero modificar(Genero t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Genero> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Genero> listID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

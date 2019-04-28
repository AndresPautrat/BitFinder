package com.tindora.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tindora.model.entities.Emparejamiento;
import com.tindora.model.repository.EmparejamientoRepository;
import com.tindora.service.EmparejamientoService;
@Service
public class EmparejamientoServiceImpl implements EmparejamientoService{
	@Autowired
	private EmparejamientoRepository emparejamientoRepos;
	@Override
	public Emparejamiento registrar(Emparejamiento t) {
		// TODO Auto-generated method stub
		return emparejamientoRepos.save(t);
	}

	@Override
	public Emparejamiento modificar(Emparejamiento t) {
		// TODO Auto-generated method stub
		return emparejamientoRepos.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		emparejamientoRepos.deleteById(id);
	}

	@Override
	public List<Emparejamiento> listar() {
		// TODO Auto-generated method stub
		return emparejamientoRepos.findAll();
	}

	@Override
	public Optional<Emparejamiento> listID(int id) {
		// TODO Auto-generated method stub
		return emparejamientoRepos.findById(id);
	}

}

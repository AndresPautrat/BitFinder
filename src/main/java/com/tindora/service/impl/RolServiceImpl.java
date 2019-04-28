package com.tindora.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tindora.model.entities.Rol;
import com.tindora.model.repository.RolRepository;
import com.tindora.service.RolService;

@Service
public class RolServiceImpl implements RolService {
	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public Rol registrar(Rol t) {
		// TODO Auto-generated method stub
		return rolRepository.save(t);
	}

	@Override
	public Rol modificar(Rol t) {
		// TODO Auto-generated method stub
		return rolRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		rolRepository.deleteById(id);
	}

	@Override
	public List<Rol> listar() {
		// TODO Auto-generated method stub
		return rolRepository.findAll();
	}

	@Override
	public Optional<Rol> listID(int id) {
		// TODO Auto-generated method stub
		return rolRepository.findById(id);
	}

}

package com.tindora.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tindora.dto.MenuListaRolDTO;
import com.tindora.model.entities.Menu;
import com.tindora.model.repository.MenuRepository;
import com.tindora.model.repository.MenuRolRepository;
import com.tindora.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private MenuRolRepository menuRolRepository;
	
	@Override
	public Menu registrar(Menu t) {
		// TODO Auto-generated method stub
		return menuRepository.save(t);
	}

	@Override
	public Menu modificar(Menu t) {
		// TODO Auto-generated method stub
		return menuRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		menuRepository.deleteById(id);
	}

	@Override
	public List<Menu> listar() {
		// TODO Auto-generated method stub
		return menuRepository.findAll();
	}

	@Override
	public Optional<Menu> listID(int id) {
		// TODO Auto-generated method stub
		return menuRepository.findById(id);
	}

	@Override
	public Menu registrar(MenuListaRolDTO menuListaRol) {
		menuRepository.save(menuListaRol.getMenu());
		
		menuListaRol.getRoles().forEach(rol->menuRolRepository.registrar(
				menuListaRol.getMenu().getId(), rol.getId()));
		return null;
	}

	
}

package com.tindora.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tindora.dto.MenuListaRolDTO;
import com.tindora.exception.ModelNotFoundException;
import com.tindora.model.entities.Menu;
import com.tindora.service.MenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	@GetMapping
	public ResponseEntity<List<Menu>> listar() {
		List<Menu> menu = new ArrayList<>();
		menu = menuService.listar();
		return new ResponseEntity<List<Menu>>(menu, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Menu> ListarId(@PathVariable("id") Integer id) {
		Optional<Menu> menu = menuService.listID(id);
		if (!menu.isPresent()) {
			throw new ModelNotFoundException("ID" + id);
		}
		return new ResponseEntity<Menu>(menu.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Menu> registrar(@Valid @RequestBody MenuListaRolDTO menuDTO) {
		Menu men = new Menu();
		men = menuService.registrar(menuDTO);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(men.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Menu> actualizar(@Valid @RequestBody Menu menu) {
		menuService.modificar(menu);
		return new ResponseEntity<Menu>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Menu> emparejamiento = menuService.listID(id);
		if (!emparejamiento.isPresent()) {
			throw new ModelNotFoundException("ID: " + id);
		} else {
			menuService.eliminar(id);
		}
	}
	
}

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

import com.tindora.exception.ModelNotFoundException;

import com.tindora.model.entities.Rol;
import com.tindora.service.RolService;

@RestController
@RequestMapping("/roles")
public class RolController {
	@Autowired
	private RolService rolService;
	
	@GetMapping
	public ResponseEntity<List<Rol>> listar(){
		List<Rol> rol = new ArrayList<>();
		rol = rolService.listar();
		return new ResponseEntity<List<Rol>>(rol, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Rol> listarId(@PathVariable("id") Integer id) {
		Optional<Rol> rol = rolService.listID(id);
		if (!rol.isPresent()) {
			throw new ModelNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Rol>(rol.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Rol> registrar(@Valid @RequestBody Rol rol){
		Rol ro = new Rol();
		ro = rolService.registrar(rol);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ro.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	public ResponseEntity<Rol> actualizar(@Valid @RequestBody Rol rol) {		
		rolService.modificar(rol);
		return new ResponseEntity<Rol>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Rol> rol = rolService.listID(id);
		if (!rol.isPresent()) {
			throw new ModelNotFoundException("ID: " + id);
		} else {
			rolService.eliminar(id);
		}
	}
	
}

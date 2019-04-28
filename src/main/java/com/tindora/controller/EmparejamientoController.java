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

import com.tindora.model.entities.Emparejamiento;
import com.tindora.service.EmparejamientoService;

@RestController
@RequestMapping("/emparejamientos")
public class EmparejamientoController {
	@Autowired
	private EmparejamientoService emparejamientoService;
	
	@GetMapping
	public ResponseEntity<List<Emparejamiento>> listar() {
		List<Emparejamiento> emparejamiento = new ArrayList<>();
		emparejamiento = emparejamientoService.listar();
		return new ResponseEntity<List<Emparejamiento>>(emparejamiento, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Emparejamiento> ListarId(@PathVariable("id") Integer id) {
		Optional<Emparejamiento> emparejamiento = emparejamientoService.listID(id);
		if (!emparejamiento.isPresent()) {
			throw new ModelNotFoundException("ID" + id);
		}
		return new ResponseEntity<Emparejamiento>(emparejamiento.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Emparejamiento> registrar(@Valid @RequestBody Emparejamiento emparejamiento) {
		Emparejamiento emp = new Emparejamiento();
		emp = emparejamientoService.registrar(emparejamiento);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emp.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Emparejamiento> actualizar(@Valid @RequestBody Emparejamiento emparejamiento) {
		emparejamientoService.modificar(emparejamiento);
		return new ResponseEntity<Emparejamiento>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Emparejamiento> emparejamiento = emparejamientoService.listID(id);
		if (!emparejamiento.isPresent()) {
			throw new ModelNotFoundException("ID: " + id);
		} else {
			emparejamientoService.eliminar(id);
		}
	}
}

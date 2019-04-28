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
import com.tindora.model.entities.Cancion;
import com.tindora.service.CancionService;

@RestController
@RequestMapping("/canciones")
public class CancionController {

	@Autowired
	CancionService cancionService;

	@GetMapping
	public ResponseEntity<List<Cancion>> listar() {
		List<Cancion> cancion = new ArrayList<>();
		cancion = cancionService.listar();

		return new ResponseEntity<List<Cancion>>(cancion, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cancion> ListarId(@PathVariable("id") Integer id) {
		Optional<Cancion> cancion = cancionService.listID(id);
		if (!cancion.isPresent()) {
			throw new ModelNotFoundException("ID" + id);
		}
		return new ResponseEntity<Cancion>(cancion.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cancion> registrar(@Valid @RequestBody Cancion cancion) {
		Cancion can = new Cancion();
		can = cancionService.registrar(cancion);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(can.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Cancion> actualizar(@Valid @RequestBody Cancion cancion) {
		cancionService.modificar(cancion);
		return new ResponseEntity<Cancion>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Cancion> cancion = cancionService.listID(id);
		if (!cancion.isPresent()) {
			throw new ModelNotFoundException("ID: " + id);
		} else {
			cancionService.eliminar(id);
		}
	}
}

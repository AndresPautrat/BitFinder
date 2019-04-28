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
import com.tindora.model.entities.Genero;
import com.tindora.service.GeneroService;


@RestController
@RequestMapping("/genero")
public class GeneroController {
	@Autowired
	private GeneroService generoService;

	@GetMapping
	public ResponseEntity<List<Genero>> listar(){
		List<Genero> genero = new ArrayList<>();
		genero = generoService.listar();
		return new ResponseEntity<List<Genero>>(genero, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Genero> listarId(@PathVariable("id") Integer id) {
		Optional<Genero> genero = generoService.listID(id);
		if (!genero.isPresent()) {
			throw new ModelNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Genero>(genero.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Genero> registrar(@Valid @RequestBody Genero genero){
		Genero gen = new Genero();
		gen = generoService.registrar(genero);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(gen.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	public ResponseEntity<Genero> actualizar(@Valid @RequestBody Genero genero) {		
		generoService.modificar(genero);
		return new ResponseEntity<Genero>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Genero> genero = generoService.listID(id);
		if (!genero.isPresent()) {
			throw new ModelNotFoundException("ID: " + id);
		} else {
			generoService.eliminar(id);
		}
	}

}

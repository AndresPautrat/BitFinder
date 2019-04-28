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
import com.tindora.model.entities.Artista;
import com.tindora.service.ArtistaService;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

	@Autowired
	ArtistaService artistaService;

	@GetMapping
	public ResponseEntity<List<Artista>> listar() {
		List<Artista> artistas = new ArrayList<>();
		artistas = artistaService.listar();

		return new ResponseEntity<List<Artista>>(artistas, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Artista> ListarId(@PathVariable("id") Integer id) {
		Optional<Artista> artista = artistaService.listID(id);
		if(!artista.isPresent()){
			throw new ModelNotFoundException("ID" + id);
		}
		return new ResponseEntity<Artista>(artista.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Artista> registrar(@Valid @RequestBody Artista artista) {
		Artista art = new Artista();
		art = artistaService.registrar(artista);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(art.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Artista> actualizar(@Valid @RequestBody Artista artista) {
		artistaService.modificar(artista);
		return new ResponseEntity<Artista>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Artista> artista = artistaService.listID(id);
		if (!artista.isPresent()) {
			throw new ModelNotFoundException("ID: " + id);
		} else {
			artistaService.eliminar(id);
		}
	}

}

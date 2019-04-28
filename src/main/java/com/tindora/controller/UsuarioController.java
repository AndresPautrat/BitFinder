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

import com.tindora.dto.UsuarioListasDTOtest;
import com.tindora.exception.ModelNotFoundException;
import com.tindora.model.entities.Usuario;
import com.tindora.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listar(){
		List<Usuario> usuario = new ArrayList<>();
		usuario = usuarioService.listar();
		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> listarId(@PathVariable("id") Integer id) {
		Optional<Usuario> usuario = usuarioService.listID(id);
		if (!usuario.isPresent()) {
			throw new ModelNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> registrar(@Valid @RequestBody UsuarioListasDTOtest usuarioDTO){
		Usuario usu = new Usuario();
		usu = usuarioService.registrar(usuarioDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usu.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	public ResponseEntity<Usuario> actualizar(@Valid @RequestBody Usuario usuario) {		
		usuarioService.modificar(usuario);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Usuario> usuario = usuarioService.listID(id);
		if (!usuario.isPresent()) {
			throw new ModelNotFoundException("ID: " + id);
		} else {
			usuarioService.eliminar(id);
		}
	}
	
}

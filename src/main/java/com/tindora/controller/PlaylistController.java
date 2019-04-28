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

import com.tindora.dto.PlaylistListaCancionDTO;
import com.tindora.exception.ModelNotFoundException;
import com.tindora.model.entities.Playlist;
import com.tindora.service.PlaylistService;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {
	@Autowired
	private PlaylistService playlistService;
	
	@GetMapping
	public ResponseEntity<List<Playlist>> listar(){
		List<Playlist> playlist = new ArrayList<>();
		playlist = playlistService.listar();
		return new ResponseEntity<List<Playlist>>(playlist, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Playlist> listarId(@PathVariable("id") Integer id) {
		Optional<Playlist> playlist = playlistService.listID(id);
		if (!playlist.isPresent()) {
			throw new ModelNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Playlist>(playlist.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Playlist> registrar(@Valid @RequestBody PlaylistListaCancionDTO playlistDTO){
		Playlist play = new Playlist();
		play = playlistService.registrar(playlistDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(play.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	public ResponseEntity<Playlist> actualizar(@Valid @RequestBody Playlist playlist) {		
		playlistService.modificar(playlist);
		return new ResponseEntity<Playlist>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Playlist> playlist = playlistService.listID(id);
		if (!playlist.isPresent()) {
			throw new ModelNotFoundException("ID: " + id);
		} else {
			playlistService.eliminar(id);
		}
	}
}

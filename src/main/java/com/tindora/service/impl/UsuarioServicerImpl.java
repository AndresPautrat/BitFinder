package com.tindora.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tindora.dto.UsuarioListasDTOtest;
import com.tindora.model.entities.Usuario;
import com.tindora.model.repository.ArtistaUsuarioRepository;
import com.tindora.model.repository.GeneroUsuarioRepository;
import com.tindora.model.repository.UsuarioPlaylistRepository;
import com.tindora.model.repository.UsuarioRepository;
import com.tindora.model.repository.UsuarioRolRepository;
import com.tindora.service.UsuarioService;

@Service
public class UsuarioServicerImpl implements UsuarioService {
	
	

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired 
	private ArtistaUsuarioRepository artistaUsuarioRepository;
	@Autowired
	private GeneroUsuarioRepository generoUsuarioRepository;
	@Autowired
	private UsuarioPlaylistRepository usuarioPlaylistRepository;
	@Autowired 
	private UsuarioRolRepository usuarioRolRepository;
	
	
	
	@Override
	public Usuario registrar(Usuario t) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(t);
	}

	@Override
	public Usuario modificar(Usuario t) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> listID(int id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}

	@Transactional
	@Override
	public Usuario registrar(UsuarioListasDTOtest usuarioList) {
		usuarioRepository.save(usuarioList.getUsuario());
		
		usuarioList.getArtistas().forEach(artista->artistaUsuarioRepository.registrar(usuarioList.getUsuario().getId(), artista.getId()));
		usuarioList.getGeneros().forEach(genero->generoUsuarioRepository.registrar(usuarioList.getUsuario().getId(), genero.getId()));
		usuarioList.getPlaylists().forEach(playlist->usuarioPlaylistRepository.registrar(usuarioList.getUsuario().getId(), playlist.getId()));
		usuarioList.getRoles().forEach(rol->usuarioRolRepository.registrar(usuarioList.getUsuario().getId(), rol.getId()));
		
		
		return usuarioList.getUsuario();
	}
	
	
}

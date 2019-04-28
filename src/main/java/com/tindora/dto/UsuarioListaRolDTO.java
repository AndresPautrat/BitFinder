package com.tindora.dto;

import java.util.List;

import com.tindora.model.entities.Rol;
import com.tindora.model.entities.Usuario;

public class UsuarioListaRolDTO {

	private Usuario usuario;
	private List<Rol> roles;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Rol> getRoles() {
		return roles;
	}
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
	
}

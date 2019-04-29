package com.tindora.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 4, max = 50, message = "El password debe de tener como minimo 4 caracteres")
	@Column(name = "password", nullable = false, length = 50)
	private String password;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<DetalleUsuario> getDetalleUsuario() {
		return detalleUsuario;
	}

	public void setDetalleUsuario(List<DetalleUsuario> detalleUsuario) {
		this.detalleUsuario = detalleUsuario;
	}

	
	
	
}

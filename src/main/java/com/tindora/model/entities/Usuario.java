package com.tindora.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min = 3, max = 70, message = "El nombre del usuario debe detener como minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;

	@Size(min = 3, max = 70, message = "El apellido del usuario debe tener como minimo 3 caracteres")
	@Column(name = "apellido", nullable = false, length = 70)
	private String apellido;

	@Size(min = 4, max = 50, message = "El password debe de tener como minimo 4 caracteres")
	@Column(name = "password", nullable = false, length = 50)
	private String password;

	@Column(name = "estado", nullable = false, length = 1)
	private Integer estado;

	@Column(name = "tarjeta", nullable = false, length = 16)
	private Integer tarjeta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Integer tarjeta) {
		this.tarjeta = tarjeta;
	}

}

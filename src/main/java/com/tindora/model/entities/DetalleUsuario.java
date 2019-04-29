package com.tindora.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="detalle_usuario")
public class DetalleUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	@Size(min = 3, max = 70, message = "El nombre del usuario debe detener como minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;

	@Size(min = 3, max = 70, message = "El apellido del usuario debe tener como minimo 3 caracteres")
	@Column(name = "apellido", nullable = false, length = 70)
	private String apellido;

	

	@Column(name = "estado", nullable = false, length = 1)
	private Integer estado;

	@Column(name = "tarjeta", nullable = false, length = 16)
	private Integer tarjeta;

	
}

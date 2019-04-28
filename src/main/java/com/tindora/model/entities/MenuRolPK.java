package com.tindora.model.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Embeddable
public class MenuRolPK  implements Serializable{
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "menu_id",nullable = false)
	private Menu menu;
	
	@ManyToOne
	@JoinColumn(name = "rol_id",nullable = false)
	private Rol rol;
}

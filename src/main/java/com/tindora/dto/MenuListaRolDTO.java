package com.tindora.dto;

import java.util.List;

import com.tindora.model.entities.Menu;
import com.tindora.model.entities.Rol;

public class MenuListaRolDTO {
private Menu menu;
private List<Rol> roles;
public Menu getMenu() {
	return menu;
}
public void setMenu(Menu menu) {
	this.menu = menu;
}
public List<Rol> getRoles() {
	return roles;
}
public void setRoles(List<Rol> roles) {
	this.roles = roles;
}

}

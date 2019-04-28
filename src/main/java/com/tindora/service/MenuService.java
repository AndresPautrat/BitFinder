package com.tindora.service;

import com.tindora.dto.MenuListaRolDTO;
import com.tindora.model.entities.Menu;

public interface MenuService extends CrudService<Menu>{

	Menu registrar(MenuListaRolDTO menuListaRol);
}

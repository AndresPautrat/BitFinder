package com.tindora.service;

import com.tindora.dto.UsuarioListasDTOtest;
import com.tindora.model.entities.Usuario;

public interface UsuarioService extends CrudService<Usuario>{

	Usuario registrar(UsuarioListasDTOtest usuarioList);
}

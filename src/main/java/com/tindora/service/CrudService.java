package com.tindora.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {

	T registrar(T t);
	
	T modificar(T t);
	
	void eliminar(int id);
	
	List<T> listar();
	
	Optional<T> listID(int id);

}

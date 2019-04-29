package com.tindora.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tindora.model.entities.MenuRol;

@Repository
public interface MenuRolRepository 
extends JpaRepository<MenuRol, Integer> {

	//Transaction 
	@Modifying
	@Transactional
	//DML:insert, update o delete
	@Query(value="INSERT INTO menu_rol(menu_id,rol_id) "
			+ "VALUES(:menuId,:rolId) ",nativeQuery=true)
	Integer registrar (@Param("menuId") Integer menuId,
			@Param("rolId") Integer rolId);

}

package com.atsistemas.formacion.base.spring.practicafinal.superHeroes.repository;

import java.util.List;

import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.model.FiltrosSuperHeroe;
import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.model.SuperHeroe;

public interface SuperHeroeRepository {
	
	List<SuperHeroe> findAll();
	
	SuperHeroe findById(Integer id);
	
	SuperHeroe insert(SuperHeroe superHeroe);
	
	SuperHeroe update(SuperHeroe superHeroe);
	
	void delete(Integer idSuperHeroe);
	
	List<SuperHeroe> findByEstado(String estado);
	
	List<SuperHeroe> search (FiltrosSuperHeroe filtrosSuperHeroe);
	
	//TODO
	List<SuperHeroe> searchCadena (FiltrosSuperHeroe filtrosSuperHeroe);
	
	
	

}

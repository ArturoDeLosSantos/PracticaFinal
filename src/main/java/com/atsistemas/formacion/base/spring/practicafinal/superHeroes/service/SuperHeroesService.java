package com.atsistemas.formacion.base.spring.practicafinal.superHeroes.service;

import java.util.List;

import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.model.FiltrosSuperHeroe;
import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.model.SuperHeroe;

public interface SuperHeroesService {
	
	void guardarSuperHeroe(SuperHeroe superHeroe);
	
	List<SuperHeroe> listarSuperHeroe();
	
	SuperHeroe buscarSuperHeroe(Integer id);
	
	void eliminarSuperHeroe(Integer idSuperHeroe);
	
	List<SuperHeroe> buscarSuperHeroeEstado(String estado);
	
	List<SuperHeroe> buscarSuperHeroes(FiltrosSuperHeroe filtrosSuperHeroe);
	
	//TODO
	List<SuperHeroe> buscarSuperHeroesCadena(FiltrosSuperHeroe filtrosSuperHeroe);


}

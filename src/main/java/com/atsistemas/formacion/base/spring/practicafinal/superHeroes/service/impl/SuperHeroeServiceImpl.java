package com.atsistemas.formacion.base.spring.practicafinal.superHeroes.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.model.FiltrosSuperHeroe;
import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.model.SuperHeroe;
import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.repository.SuperHeroeRepository;
import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.service.SuperHeroesService;

@Service
public class SuperHeroeServiceImpl implements SuperHeroesService{
	

	private SuperHeroeRepository superHeroeRepository;
	
	
	
	public SuperHeroeServiceImpl(SuperHeroeRepository superHeroeRepository) {
		this.superHeroeRepository = superHeroeRepository;
	}



	@Override
	@Transactional
	public void guardarSuperHeroe(SuperHeroe superHeroe) {
		if(superHeroe.getId()==null) {
			superHeroeRepository.insert(superHeroe);
		}else {
			superHeroeRepository.update(superHeroe);
		}
	}



	@Override
	public List<SuperHeroe> listarSuperHeroe() {
		return superHeroeRepository.findAll();
	}



	@Override
	public SuperHeroe buscarSuperHeroe(Integer id) {
		return superHeroeRepository.findById(id);
	}



	@Override
	@Transactional
	public void eliminarSuperHeroe(Integer idSuperHeroe) {
		superHeroeRepository.delete(idSuperHeroe);
		
	}



	@Override
	public List<SuperHeroe> buscarSuperHeroeEstado(String estado) {
		return superHeroeRepository.findByEstado(estado);
	}



	@Override
	public List<SuperHeroe> buscarSuperHeroes(FiltrosSuperHeroe filtrosSuperHeroe) {
		return superHeroeRepository.search(filtrosSuperHeroe);
	}



	@Override
	public List<SuperHeroe> buscarSuperHeroesCadena(FiltrosSuperHeroe filtrosSuperHeroe) {
		return superHeroeRepository.searchCadena(filtrosSuperHeroe);
	}



}

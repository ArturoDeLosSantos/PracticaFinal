package com.atsistemas.formacion.base.spring.practicafinal.superHeroes.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.model.SuperHeroe;
import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.repository.SuperHeroeRepository;
import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.service.SuperHeroesService;

@Service
public class SuperHeroeServiceImpl implements SuperHeroesService{
	
	//TODO
	//quitar de mapa de memoria y hacer base de datos
//	private Map<Integer,SuperHeroe> superHeroes;
//	
//	public SuperHeroeServiceImpl() {
//		superHeroes = new HashMap<>();
//		superHeroes.put(siguienteIdSuperHeroe(), new SuperHeroe(siguienteIdSuperHeroe(),"Superman","vivo"));
//		superHeroes.put(siguienteIdSuperHeroe(), new SuperHeroe(siguienteIdSuperHeroe(),"batman","muerto"));
//		superHeroes.put(siguienteIdSuperHeroe(), new SuperHeroe(siguienteIdSuperHeroe(),"hulk","vivo"));	
//		
//	}
//	
//	private Integer siguienteIdSuperHeroe() {
//		return superHeroes.values().stream().max(Comparator.comparing(SuperHeroe::getId)).map(p-> p.getId() + 1).orElse(1);
//	}
	
	

//	@Override
//	public void guardarSuperHeroe(SuperHeroe superHeroe) {
//		if(superHeroe.getId()==null) {
//			Integer siguienteIdSuperHeroe = siguienteIdSuperHeroe();
//			superHeroe.setId(siguienteIdSuperHeroe);
//			superHeroes.put(siguienteIdSuperHeroe,superHeroe);
//		}else {
//			SuperHeroe superHeroeAlmacenado = superHeroes.get(superHeroe.getId());
//			superHeroeAlmacenado.setNombre(superHeroe.getNombre());
//			superHeroeAlmacenado.setEstado(superHeroe.getEstado());
//		}
//		
//	}
//
//	@Override
//	public List<SuperHeroe> listarSuperHeroe() {
//		return new ArrayList<>(superHeroes.values());
//	}
//
//	@Override
//	public SuperHeroe buscarSuperHeroe(Integer id) {
//		return superHeroes.get(id);
//	}
//
//	@Override
//	public void eliminarSuperHeroe(Integer idSuperHeroe) {
//		superHeroes.remove(idSuperHeroe);
//		
//	}
//
//
//	@Override
//	public List<SuperHeroe> buscarSuperHeroeEstado(String estado) {
//		return superHeroes.find;
//	}

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
}

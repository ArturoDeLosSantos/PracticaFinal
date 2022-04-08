package com.atsistemas.formacion.base.spring.practicafinal.superHeroes.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.model.FiltrosSuperHeroe;
import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.model.SuperHeroe;
import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.service.SuperHeroesService;

@RestController
public class SuperHeroesController {
	
	private SuperHeroesService superHeroeService;
	
	public SuperHeroesController (SuperHeroesService superHeroeService) {
		this.superHeroeService = superHeroeService;
	}
	
	//Consultar todos los SH
	@GetMapping(value = "/superHeroes",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SuperHeroe> listadoSuperHeroes(){
		return superHeroeService.listarSuperHeroe();
	}
	
	//Consultar un unico SH por id
	@GetMapping(value = "/superHeroes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuperHeroe> obtenerSuperHeroe(@PathVariable(name="id") Integer id){
		SuperHeroe superHeroe = superHeroeService.buscarSuperHeroe(id);
		if(superHeroe != null) {
			return ResponseEntity.status(HttpStatus.OK).body(superHeroe);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(superHeroe);
	}
	
	//Crear un SH
	@PostMapping(value = "/superHeroes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public SuperHeroe crearSuperHeroe(@RequestBody SuperHeroe superHeroe) {
		superHeroeService.guardarSuperHeroe(superHeroe);
		return superHeroe;
	}

	//Modificar un SH
	@PutMapping(value = "/superHeroes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SuperHeroe modificarSuperHeroe(@PathVariable(name = "id") Integer id, @RequestBody SuperHeroe superHeroe) {
		superHeroe.setId(id);
		superHeroeService.guardarSuperHeroe(superHeroe);
		return superHeroe;
	}
	
	//Eliminar un SH
	@DeleteMapping(value = "/superHeroes/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void eliminarSuperHeroe(@PathVariable(name="id") Integer id) {
		superHeroeService.eliminarSuperHeroe(id);
	}
	
	//Consultar SH por su estado
	@GetMapping ( value = "/superHeroes/estados/{estado}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SuperHeroe> obtenerSuperHeroesEstado(@PathVariable(value = "estado") String estado){
		return superHeroeService.buscarSuperHeroeEstado(estado);
	}
	
	//Colsultar SH por filtros
	@GetMapping(value = "/superHeroes/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SuperHeroe> buscarSuperHeroes(FiltrosSuperHeroe filtrosSuperHeroe) {
		return superHeroeService.buscarSuperHeroes(filtrosSuperHeroe);
	}
	
	//TODO
	//Consultar todos los súper héroes que contienen, en su nombre, el valor de un parámetro enviado en la petición
	@GetMapping(value = "/superHeroes/searchName", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SuperHeroe> buscarNombreSuperHeroes(FiltrosSuperHeroe filtrosSuperHeroe) {
		return superHeroeService.buscarSuperHeroesCadena(filtrosSuperHeroe);
	}
	
	
	
	

}

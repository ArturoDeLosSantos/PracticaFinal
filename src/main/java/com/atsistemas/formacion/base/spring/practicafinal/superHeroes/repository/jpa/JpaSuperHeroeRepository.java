package com.atsistemas.formacion.base.spring.practicafinal.superHeroes.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.model.FiltrosSuperHeroe;
import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.model.SuperHeroe;
import com.atsistemas.formacion.base.spring.practicafinal.superHeroes.repository.SuperHeroeRepository;

@Repository
public class JpaSuperHeroeRepository implements SuperHeroeRepository{
	
	@PersistenceContext
	private EntityManager em; 
	
	public JpaSuperHeroeRepository() {	
	}

	@Override
	public List<SuperHeroe> findAll() {
		return em.createQuery("FROM SuperHeroe", SuperHeroe.class).getResultList();
	}

	@Override
	public SuperHeroe findById(Integer id) {
		return em.find(SuperHeroe.class, id);
	}

	@Override
	public SuperHeroe insert(SuperHeroe superHeroe) {
		em.persist(superHeroe);
		return superHeroe;
	}

	@Override
	public SuperHeroe update(SuperHeroe superHeroe) {
		em.merge(superHeroe);
		return superHeroe;
	}

	@Override
	public void delete(Integer idSuperHeroe) {
		em.createQuery("DELETE FROM SuperHeroe WHERE id = ?1").setParameter(1,idSuperHeroe).executeUpdate();
		
	}

	@Override
	public List<SuperHeroe> findByEstado(String estado) {
		return em.createQuery("FROM SuperHeroe s WHERE s.estado = :estado",SuperHeroe.class)
				.setParameter("estado", estado).getResultList();
	}

	@Override
	public List<SuperHeroe> search(FiltrosSuperHeroe filtrosSuperHeroe) {
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<SuperHeroe> query = criteriaBuilder.createQuery(SuperHeroe.class);
		Root<SuperHeroe> root = query.from(SuperHeroe.class);
		Predicate predicate = criteriaBuilder.conjunction();
		
		if(filtrosSuperHeroe.getNombre() != null) {
			predicate = criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("nombre"),filtrosSuperHeroe.getNombre()));
		}
		
		if(filtrosSuperHeroe.getEstado() != null) {
			predicate = criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("estado"),filtrosSuperHeroe.getEstado()));
		}
		
		query.where(predicate);

		return em.createQuery(query).getResultList();
	}

}

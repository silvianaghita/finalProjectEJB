package com.example.finalprojectejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.finalprojectejb.dto.PromoDTO;
import com.example.finalprojectejb.model.Promo;
import com.example.finalprojectejb.util.PromoConverter;


/**
 * Session Bean implementation class PromoDAO
 */
@Stateless
public class PromoDAO implements PromoDAORemote {
	
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public PromoDAO() {
    
    }

	@Override
	public void insert(PromoDTO entity) {
		Promo promo=new Promo();
		PromoConverter.dtoToPromo(entity, promo);
		entityManager.persist(promo);
		
	}

	@Override
	public PromoDTO findById(int id) {
		PromoDTO promoDTO = new PromoDTO();
		Promo promo= entityManager.find(Promo.class, id);
		PromoConverter.promoToDto(promo, promoDTO);
		return promoDTO;
	}

	@Override
	public void delete(PromoDTO entity) {
		Promo promo=new Promo();
		PromoConverter.dtoToPromo(entity, promo);
		if (!entityManager.contains(promo)) {
			promo = entityManager.merge(promo);
		}
		entityManager.remove(promo);
		
	}

	@Override
	public void update(PromoDTO entity) {
		Promo promo=new Promo();
		PromoConverter.dtoToPromo(entity, promo);
		entityManager.merge(promo);
		
	}
	

}

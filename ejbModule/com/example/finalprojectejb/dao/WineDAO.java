package com.example.finalprojectejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.finalprojectejb.dto.WineDTO;
import com.example.finalprojectejb.model.Wine;
import com.example.finalprojectejb.util.WineConverter;

/**
 * Session Bean implementation class WineDAO
 */
@Stateless
public class WineDAO implements WineDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public WineDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(WineDTO entity) {
		Wine wine=new Wine();
		System.out.println(entity.getName());
		WineConverter.dtoToWine(entity, wine);
		System.out.println(wine.getName());
		entityManager.persist(wine);
	}

	@Override
	public WineDTO findById(int id) {
		WineDTO wineDTO = new WineDTO();
		Wine wine= entityManager.find(Wine.class, id);
		WineConverter.wineToDto(wine, wineDTO);
		return wineDTO;
	}

	@Override
	public void delete(WineDTO entity) {
		Wine wine=new Wine();
		WineConverter.dtoToWine(entity, wine);
		if (!entityManager.contains(wine)) {
			wine = entityManager.merge(wine);
		}
		entityManager.remove(wine);
		
	}

	@Override
	public void update(WineDTO entity) {
		Wine wine=new Wine();
		WineConverter.dtoToWine(entity, wine);
		entityManager.merge(wine);
		
	}


}

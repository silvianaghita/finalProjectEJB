package com.example.finalprojectejb.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.finalprojectejb.dto.StockClientB2BDTO;
import com.example.finalprojectejb.model.StockClientB2B;
import com.example.finalprojectejb.util.StockClientB2BConverter;

/**
 * Session Bean implementation class StockClientB2BDAO
 */
@Stateless
public class StockClientB2BDAO implements StockClientB2BDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public StockClientB2BDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(StockClientB2BDTO entity) {
		StockClientB2B stockClientB2B=new StockClientB2B();
		StockClientB2BConverter.dtoToStockClientB2B(entity, stockClientB2B);
		entityManager.persist(stockClientB2B);
		
	}

	@Override
	public StockClientB2BDTO findById(int id) {
		StockClientB2BDTO stockClientB2BDTO = new StockClientB2BDTO();
		StockClientB2B stockClientB2B= entityManager.find(StockClientB2B.class, id);
		StockClientB2BConverter.stockClientB2BToDto(stockClientB2B, stockClientB2BDTO);
		return stockClientB2BDTO;
	}

	@Override
	public void delete(StockClientB2BDTO entity) {
		StockClientB2B stockClientB2B=new StockClientB2B();
		StockClientB2BConverter.dtoToStockClientB2B(entity, stockClientB2B);
		if (!entityManager.contains(stockClientB2B)) {
			stockClientB2B = entityManager.merge(stockClientB2B);
		}
		entityManager.remove(stockClientB2B);
		
	}

	@Override
	public void update(StockClientB2BDTO entity) {
		StockClientB2B stockClientB2B=new StockClientB2B();
		StockClientB2BConverter.dtoToStockClientB2B(entity, stockClientB2B);
		entityManager.merge(stockClientB2B);
		
	}
	
}

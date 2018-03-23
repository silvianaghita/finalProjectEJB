package com.example.finalprojectejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.finalprojectejb.dto.StockSupplierDTO;
import com.example.finalprojectejb.model.StockSupplier;
import com.example.finalprojectejb.util.StockSupplierConverter;

/**
 * Session Bean implementation class StockSupplierDAO
 */
@Stateless
public class StockSupplierDAO implements StockSupplierDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public StockSupplierDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(StockSupplierDTO entity) {
		StockSupplier stockSupplier=new StockSupplier();
		StockSupplierConverter.dtoToStockSupplier(entity, stockSupplier);
		entityManager.persist(stockSupplier);
		
	}

	@Override
	public StockSupplierDTO findById(int id) {
		StockSupplierDTO stockSupplierDTO = new StockSupplierDTO();
		StockSupplier stocSupplier= entityManager.find(StockSupplier.class, id);
		StockSupplierConverter.stockSupplierToDto(stocSupplier, stockSupplierDTO);
		return stockSupplierDTO;
	}

	@Override
	public void delete(StockSupplierDTO entity) {
		StockSupplier stockSupplier=new StockSupplier();
		StockSupplierConverter.dtoToStockSupplier(entity, stockSupplier);
		if (!entityManager.contains(stockSupplier)) {
			stockSupplier = entityManager.merge(stockSupplier);
		}
		entityManager.remove(stockSupplier);
		
	}

	@Override
	public void update(StockSupplierDTO entity) {
		StockSupplier stockSupplier=new StockSupplier();
		StockSupplierConverter.dtoToStockSupplier(entity, stockSupplier);
		entityManager.merge(stockSupplier);
		
	}
	

}

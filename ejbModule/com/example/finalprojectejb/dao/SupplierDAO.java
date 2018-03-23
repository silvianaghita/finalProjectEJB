package com.example.finalprojectejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.finalprojectejb.dto.SupplierDTO;
import com.example.finalprojectejb.model.Supplier;
import com.example.finalprojectejb.util.SupplierConverter;

/**
 * Session Bean implementation class SupplierDAO
 */
@Stateless
public class SupplierDAO implements SupplierDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public SupplierDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(SupplierDTO entity) {
		Supplier supplier=new Supplier();
		SupplierConverter.dtoToSupplier(entity, supplier);
		entityManager.persist(supplier);
		
	}

	@Override
	public SupplierDTO findById(int id) {
		SupplierDTO supplierDTO = new SupplierDTO();
		Supplier supplier= entityManager.find(Supplier.class, id);
		SupplierConverter.supplierToDto(supplier, supplierDTO);
		return supplierDTO;
	}

	@Override
	public void delete(SupplierDTO entity) {
		Supplier supplier=new Supplier();
		SupplierConverter.dtoToSupplier(entity, supplier);
		if (!entityManager.contains(supplier)) {
			supplier = entityManager.merge(supplier);
		}
		entityManager.remove(supplier);
	}

	@Override
	public void update(SupplierDTO entity) {
		Supplier supplier=new Supplier();
		SupplierConverter.dtoToSupplier(entity, supplier);
		entityManager.merge(supplier);
		
	}
	

}

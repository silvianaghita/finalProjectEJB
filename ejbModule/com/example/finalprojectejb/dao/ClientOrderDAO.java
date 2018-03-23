package com.example.finalprojectejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.finalprojectejb.dto.ClientOrderDTO;
import com.example.finalprojectejb.model.ClientOrder;
import com.example.finalprojectejb.util.ClientOrderConverter;

/**
 * Session Bean implementation class ClientOrderDAO
 */
@Stateless
public class ClientOrderDAO implements ClientOrderDAORemote {
	
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public ClientOrderDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(ClientOrderDTO entity) {
		ClientOrder order=new ClientOrder();
		ClientOrderConverter.dtoToClientOrder(entity, order);
		entityManager.persist(order);
		
	}

	@Override
	public ClientOrderDTO findById(int id) {
		ClientOrderDTO clientOrderDTO = new ClientOrderDTO();
		ClientOrder order= entityManager.find(ClientOrder.class, id);
		ClientOrderConverter.clientOrderToDto(order, clientOrderDTO);
		return clientOrderDTO;
	}

	@Override
	public void delete(ClientOrderDTO entity) {
		ClientOrder order=new ClientOrder();
		ClientOrderConverter.dtoToClientOrder(entity, order);
		if (!entityManager.contains(order)) {
			order = entityManager.merge(order);
		}
		entityManager.remove(order);
		
	}

	@Override
	public void update(ClientOrderDTO entity) {
		ClientOrder order=new ClientOrder();
		ClientOrderConverter.dtoToClientOrder(entity, order);
		entityManager.merge(order);
		
	}
	
 

}

package com.example.finalprojectejb.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.finalprojectejb.dto.OrderItemDTO;
import com.example.finalprojectejb.model.OrderItem;
import com.example.finalprojectejb.util.OrderItemConverter;

/**
 * Session Bean implementation class OrderItemDAO
 */
@Stateless
public class OrderItemDAO implements OrderItemDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public OrderItemDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(OrderItemDTO entity) {
		OrderItem orderItem=new OrderItem();
		OrderItemConverter.dtoToOrderItem(entity, orderItem);
		entityManager.persist(orderItem);

	}

	@Override
	public OrderItemDTO findById(int id) {
		OrderItemDTO orderItemDTO = new OrderItemDTO();
		OrderItem orderItem= entityManager.find(OrderItem.class, id);
		OrderItemConverter.orderItemToDto(orderItem, orderItemDTO);
		return orderItemDTO;
	}

	@Override
	public void delete(OrderItemDTO entity) {
		OrderItem orderItem=new OrderItem();
		OrderItemConverter.dtoToOrderItem(entity, orderItem);
		if (!entityManager.contains(orderItem)) {
			orderItem = entityManager.merge(orderItem);
		}
		entityManager.remove(orderItem);

	}

	@Override
	public void update(OrderItemDTO entity) {
		OrderItem orderItem=new OrderItem();
		OrderItemConverter.dtoToOrderItem(entity, orderItem);
		entityManager.merge(orderItem);

	}


}

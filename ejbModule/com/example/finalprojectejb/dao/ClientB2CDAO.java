package com.example.finalprojectejb.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.finalprojectejb.dto.ClientB2CDTO;
import com.example.finalprojectejb.model.ClientB2C;
import com.example.finalprojectejb.util.ClientB2CConverter;


/**
 * Session Bean implementation class ClientB2CDAO
 */
@Stateless
public class ClientB2CDAO implements ClientB2CDAORemote {
	
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public ClientB2CDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(ClientB2CDTO entity) {
		ClientB2C client=new ClientB2C();
		ClientB2CConverter.dtoToClientB2C(entity, client);
		entityManager.persist(client);
		
	}

	@Override
	public ClientB2CDTO findById(int id) {
		ClientB2CDTO clientB2CDTO = new ClientB2CDTO();
		ClientB2C client= entityManager.find(ClientB2C.class, id);
		ClientB2CConverter.clientB2CToDto(client, clientB2CDTO);
		return clientB2CDTO;
	}

	@Override
	public void delete(ClientB2CDTO entity) {
		ClientB2C client=new ClientB2C();
		ClientB2CConverter.dtoToClientB2C(entity, client);
		if (!entityManager.contains(client)) {
			client = entityManager.merge(client);
		}
		entityManager.remove(client);
	}

	@Override
	public void update(ClientB2CDTO entity) {
		ClientB2C client=new ClientB2C();
		ClientB2CConverter.dtoToClientB2C(entity, client);
		entityManager.merge(client);
	}
	
	
}

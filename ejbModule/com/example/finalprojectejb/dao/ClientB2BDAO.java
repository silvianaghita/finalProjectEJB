package com.example.finalprojectejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.finalprojectejb.dto.ClientB2BDTO;
import com.example.finalprojectejb.model.ClientB2B;
import com.example.finalprojectejb.util.ClientB2BConverter;

/**
 * Session Bean implementation class ClientB2BDAO
 */
@Stateless
public class ClientB2BDAO implements ClientB2BDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public ClientB2BDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(ClientB2BDTO entity) {
		ClientB2B client=new ClientB2B();
		ClientB2BConverter.dtoToClientB2B(entity, client);
		entityManager.persist(client);
	}

	@Override
	public ClientB2BDTO findById(int id) {
		ClientB2BDTO clientB2BDTO = new ClientB2BDTO();
		ClientB2B client= entityManager.find(ClientB2B.class, id);
		ClientB2BConverter.clientB2BToDto(client, clientB2BDTO);
		return clientB2BDTO;
	}

	@Override
	public void delete(ClientB2BDTO entity) {
		ClientB2B client=new ClientB2B();
		ClientB2BConverter.dtoToClientB2B(entity, client);
		if (!entityManager.contains(client)) {
			client = entityManager.merge(client);
		}
		entityManager.remove(client);
		
	}

	@Override
	public void update(ClientB2BDTO entity) {
		ClientB2B client=new ClientB2B();
		ClientB2BConverter.dtoToClientB2B(entity, client);
		entityManager.merge(client);
		
	}
	
	

}

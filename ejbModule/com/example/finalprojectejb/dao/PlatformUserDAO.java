package com.example.finalprojectejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.finalprojectejb.dto.PlatformUserDTO;
import com.example.finalprojectejb.model.PlatformUser;
import com.example.finalprojectejb.util.PlatformUserConverter;

/**
 * Session Bean implementation class PlatformUserDAO
 */
@Stateless
public class PlatformUserDAO implements PlatformUserDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;


    /**
     * Default constructor. 
     */
    public PlatformUserDAO() {
    
    }

	@Override
	public void insert(PlatformUserDTO entity) {
		PlatformUser user=new PlatformUser();
		PlatformUserConverter.dtoToPlatformUser(entity, user);
		entityManager.persist(user);
	}
	

	@Override
	public PlatformUserDTO findById(int id) {
		PlatformUserDTO platformUserDTO = new PlatformUserDTO();
		PlatformUser user=entityManager.find(PlatformUser.class, id);
		PlatformUserConverter.platformUserToDTO(user, platformUserDTO);
		return platformUserDTO;
}

	@Override
	public void delete(PlatformUserDTO entity) {
		PlatformUser user=new PlatformUser();
		PlatformUserConverter.dtoToPlatformUser(entity, user);
		if (!entityManager.contains(user)) {
		    user = entityManager.merge(user);
		}
		entityManager.remove(user);
		
	}

	@Override
	public void update(PlatformUserDTO entity) {
		PlatformUser user=new PlatformUser();
		PlatformUserConverter.dtoToPlatformUser(entity, user);
		entityManager.merge(user);
	}




}

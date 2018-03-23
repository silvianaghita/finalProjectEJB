package com.example.finalprojectejb;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class FinalProjectStatelessEjb
 */
@Stateless
public class FinalProjectStatelessEjb implements FinalProjectStatelessEjbRemote {

    /**
     * Default constructor. 
     */
    public FinalProjectStatelessEjb() {
        // TODO Auto-generated constructor stub
    }
    
	public void insertMessage(String message) {
		System.out.println("aiciaici");
		
	}

}

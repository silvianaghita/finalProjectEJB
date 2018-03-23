package com.example.finalprojectejb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ClientB2C
 *
 */
@Entity

public class ClientB2C extends PlatformUser implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String lastName;
	private String firstName;
	@Temporal(TemporalType.DATE)
	private Date registerDate;
	private String cnp;
	
	@OneToMany(mappedBy="clientB2C")
	private List<ClientOrder> orders;
	

	public ClientB2C() {
		super();
	}
   



	public List<ClientOrder> getOrders() {
		return orders;
	}




	public ClientB2C setOrders(List<ClientOrder> orders) {
		this.orders = orders;
		return this;
	}




	public String getLastName() {
		return lastName;
	}



	public ClientB2C setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}



	public String getFirstName() {
		return firstName;
	}



	public ClientB2C setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}



	public Date getRegisterDate() {
		return registerDate;
	}



	public ClientB2C setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
		return this;
	}



	public String getCnp() {
		return cnp;
	}



	public ClientB2C setCnp(String cnp) {
		this.cnp = cnp;
		return this;
	}

}

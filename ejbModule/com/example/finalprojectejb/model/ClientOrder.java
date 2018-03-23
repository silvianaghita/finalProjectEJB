package com.example.finalprojectejb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity

public class ClientOrder implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int orderNumber;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	private ClientB2C clientB2C;
	
	@OneToMany(mappedBy="order")
	private List<OrderItem> orderItems;

	public ClientOrder() {
		super();
	}
	

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}


	public ClientOrder setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
		return this;
	}


	public ClientB2C getClientB2C() {
		return clientB2C;
	}


	public ClientOrder setClientB2C(ClientB2C clientB2C) {
		this.clientB2C = clientB2C;
		return this;
	}


	public int getId() {
		return id;
	}

	public ClientOrder setId(int id) {
		this.id = id;
		return this;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ClientOrder setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public Date getDate() {
		return date;
	}

	public ClientOrder setDate(Date date) {
		this.date = date;
		return this;
	}
	
	
   
}

package com.example.finalprojectejb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: StockClientB2B
 *
 */
@Entity
public class StockClientB2B implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int price;
	private int quantity;
	private boolean active;
	private int limitQuantity;
	
	@ManyToOne
	private ClientB2B clientB2B;
	
	@OneToMany(mappedBy="stockClientB2B")
	private List<StockSupplier> supplierStocks;
	
	@OneToMany(mappedBy="stockClientB2B")
	private List<OrderItem> orderItems;
	
	

	public StockClientB2B() {
		super();
	}
	


	public boolean isActive() {
		return active;
	}


	public StockClientB2B setActive(boolean active) {
		this.active = active;
		return this;
	}


	public int getLimitQuantity() {
		return limitQuantity;
	}




	public StockClientB2B setLimitQuantity(int limitQuantity) {
		this.limitQuantity = limitQuantity;
		return this;
	}




	public List<OrderItem> getOrderItems() {
		return orderItems;
	}


	public StockClientB2B setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
		return this;
	}



	public List<StockSupplier> getSupplierStocks() {
		return supplierStocks;
	}


	public StockClientB2B setSupplierStocks(List<StockSupplier> supplierStocks) {
		this.supplierStocks = supplierStocks;
		return this;
	}


	public ClientB2B getClientB2B() {
		return clientB2B;
	}



	public StockClientB2B setClientB2B(ClientB2B clientB2B) {
		this.clientB2B = clientB2B;
		return this;
	}



	public int getId() {
		return id;
	}

	public StockClientB2B setId(int id) {
		this.id = id;
		return this;
	}

	public int getPrice() {
		return price;
	}

	public StockClientB2B setPrice(int price) {
		this.price = price;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public StockClientB2B setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	
	
   
}

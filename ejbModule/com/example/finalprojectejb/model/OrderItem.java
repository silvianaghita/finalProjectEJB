package com.example.finalprojectejb.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: OrderItem
 *
 */
@Entity

public class OrderItem implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int quantity;
	private int price;
	
	@ManyToOne
	@JoinColumn(name = "stockClientB2B_id")
	private StockClientB2B stockClientB2B;
	
	@ManyToOne 
	private ClientOrder order;
	

	public OrderItem() {
		super();
	}


	public int getId() {
		return id;
	}


	public OrderItem setId(int id) {
		this.id = id;
		return this;
	}


	public int getQuantity() {
		return quantity;
	}


	public OrderItem setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}


	public int getPrice() {
		return price;
	}


	public OrderItem setPrice(int price) {
		this.price = price;
		return this;
	}


	public StockClientB2B getStockClientB2B() {
		return stockClientB2B;
	}


	public OrderItem setStockClientB2B(StockClientB2B stockClientB2B) {
		this.stockClientB2B = stockClientB2B;
		return this;
	}


	public ClientOrder getOrder() {
		return order;
	}


	public OrderItem setOrder(ClientOrder order) {
		this.order = order;
		return this;
	}
	
   
}

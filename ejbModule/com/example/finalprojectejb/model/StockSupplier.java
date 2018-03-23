package com.example.finalprojectejb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: StockSupplier
 *
 */
@Entity

public class StockSupplier implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int price;
	private int quantity;
	
	@ManyToOne
	private Supplier supplier;
	
	@OneToMany(mappedBy="stockSupplier")
	private List<Promo> promotions;
	
	@ManyToOne
	private StockClientB2B stockClientB2B;
	
	@ManyToOne
	private Wine wine;

	public StockSupplier() {
		super();
	}
	
	
	public Wine getWine() {
		return wine;
	}
	

	public StockSupplier setWine(Wine wine) {
		this.wine = wine;
		return this;
	}



	public StockClientB2B getStockClientB2B() {
		return stockClientB2B;
	}


	public StockSupplier setStockClientB2B(StockClientB2B stockClientB2B) {
		this.stockClientB2B = stockClientB2B;
		return this;
	}

	public List<Promo> getPromotions() {
		return promotions;
	}


	public StockSupplier setPromotions(List<Promo> promotions) {
		this.promotions = promotions;
		return this;
	}



	public Supplier getSupplier() {
		return supplier;
	}


	public StockSupplier setSupplier(Supplier supplier) {
		this.supplier = supplier;
		return this;
	}


	public int getId() {
		return id;
	}

	public StockSupplier setId(int id) {
		this.id = id;
		return this;
	}

	public int getPrice() {
		return price;
	}

	public StockSupplier setPrice(int price) {
		this.price = price;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public StockSupplier setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	
	
   
}

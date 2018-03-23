package com.example.finalprojectejb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Promo
 *
 */
@Entity

public class Promo implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private int discount;
	
	@ManyToOne
	private StockSupplier stockSupplier;
	

	public Promo() {
		super();
	}


	public int getId() {
		return id;
	}


	public Promo setId(int id) {
		this.id = id;
		return this;
	}


	public Date getStartDate() {
		return startDate;
	}


	public Promo setStartDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}


	public Date getEndDate() {
		return endDate;
	}


	public Promo setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}


	public int getDiscount() {
		return discount;
	}


	public Promo setDiscount(int discount) {
		this.discount = discount;
		return this;
	}


	public StockSupplier getStockSupplier() {
		return stockSupplier;
	}


	public Promo setStockSupplier(StockSupplier stockSupplier) {
		this.stockSupplier = stockSupplier;
		return this;
	}
	
	
   
}

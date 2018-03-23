package com.example.finalprojectejb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Supplier
 *
 */
@Entity
public class Supplier extends PlatformUser implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private boolean visibility;
	private boolean wineCellarName;
	private int age;
	
	@OneToMany(mappedBy="supplier")
	private List<StockSupplier> stocks;

	public Supplier() {
		super();
	}

	
	public List<StockSupplier> getStocks() {
		return stocks;
	}


	public Supplier setStocks(List<StockSupplier> stocks) {
		this.stocks = stocks;
		return this;
	}


	public boolean isVisibility() {
		return visibility;
	}

	public Supplier setVisibility(boolean visibility) {
		this.visibility = visibility;
		return this;
	}

	public boolean isWineCellarName() {
		return wineCellarName;
	}

	public Supplier setWineCellarName(boolean wineCellarName) {
		this.wineCellarName = wineCellarName;
		return this;
	}

	public int getAge() {
		return age;
	}

	public Supplier setAge(int age) {
		this.age = age;
		return this;
	}
	
	
   
}

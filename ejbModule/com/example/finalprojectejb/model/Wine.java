package com.example.finalprojectejb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.example.finalprojectejb.util.WineType;

/**
 * Entity implementation class for Entity: Wine
 *
 */
@Entity

public class Wine implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int year;
	private String name;
	private String description;
	private String variety;
	private WineType type; 
	
	@OneToMany(mappedBy="wine")
	private List<StockSupplier> supplierStocks;

	public Wine() {
		super();
	}
	

	public List<StockSupplier> getSupplierStocks() {
		return supplierStocks;
	}


	public Wine setSupplierStocks(List<StockSupplier> supplierStocks) {
		this.supplierStocks = supplierStocks;
		return this;
	}


	public int getId() {
		return id;
	}

	public Wine setId(int id) {
		this.id = id;
		return this;
	}

	public int getYear() {
		return year;
	}

	public Wine setYear(int year) {
		this.year = year;
		return this;
	}

	public String getName() {
		return name;
	}

	public Wine setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Wine setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getVariety() {
		return variety;
	}

	public Wine setVariety(String variety) {
		this.variety = variety;
		return this;
	}

	public WineType getType() {
		return type;
	}

	public Wine setType(WineType type) {
		this.type = type;
		return this;
	}
	
	
   
}

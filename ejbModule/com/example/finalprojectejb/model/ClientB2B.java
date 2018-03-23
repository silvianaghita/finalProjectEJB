package com.example.finalprojectejb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ClientB2B
 *
 */
@Entity
public class ClientB2B extends PlatformUser implements Serializable {

	private boolean visibility;
	private String businessName;
	private String cui;
	private boolean subscribed;
	private static final long serialVersionUID = 1L;
	
	
	@OneToMany(mappedBy="clientB2B")
	private List<StockClientB2B> stocks;

	public ClientB2B() {
		super();
	}
	

	public List<StockClientB2B> getStocks() {
		return stocks;
	}


	public ClientB2B setStocks(List<StockClientB2B> stocks) {
		this.stocks = stocks;
		return this;
	}


	public boolean isVisibility() {
		return visibility;
	}

	public ClientB2B setVisibility(boolean visibility) {
		this.visibility = visibility;
		return this;
	}

	public String getBusinessName() {
		return businessName;
	}

	public ClientB2B setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}

	public String getCui() {
		return cui;
	}

	public ClientB2B setCui(String cui) {
		this.cui = cui;
		return this;
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public ClientB2B setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
		return this;
	}
	
	
   
}

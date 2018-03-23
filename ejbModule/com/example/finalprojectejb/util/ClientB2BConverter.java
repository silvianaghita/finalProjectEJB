package com.example.finalprojectejb.util;

import java.util.ArrayList;
import java.util.List;

import com.example.finalprojectejb.dto.ClientB2BDTO;
import com.example.finalprojectejb.dto.StockClientB2BDTO;
import com.example.finalprojectejb.model.ClientB2B;
import com.example.finalprojectejb.model.StockClientB2B;

public class ClientB2BConverter {
	
	public static void dtoToClientB2B(ClientB2BDTO clientB2BDTO, ClientB2B clientB2b) {
		
		List<StockClientB2B> stocks=new ArrayList<StockClientB2B>();
		
		if(clientB2BDTO.getStocks()!=null) {
		for(int i=0;i<clientB2BDTO.getStocks().size();i++) {
			StockClientB2B stock=new StockClientB2B();
			StockClientB2BConverter.dtoToStockClientB2B(clientB2BDTO.getStocks().get(i), stock);
			stocks.add(stock);
		}
		}
		
		clientB2b.setVisibility(clientB2BDTO.isVisibility())
		.setBusinessName(clientB2BDTO.getBusinessName())
		.setCui(clientB2BDTO.getCui())
		.setSubscribed(clientB2BDTO.isSubscribed())
		.setStocks(stocks)
		.setId(clientB2BDTO.getId())
		.setAddress(clientB2BDTO.getAddress())
		.setEmail(clientB2BDTO.getEmail())
		.setPassword(clientB2BDTO.getPassword())
		.setUsername(clientB2BDTO.getUsername());
		
	}

	public static void clientB2BToDto(ClientB2B clientB2b,ClientB2BDTO clientB2BDTO)  {
		List<StockClientB2BDTO> stocksDTO=new ArrayList<StockClientB2BDTO>();
		
		if(clientB2b.getStocks()!=null) {
		for(int i=0;i<clientB2b.getStocks().size();i++) {
			StockClientB2BDTO stockDTO=new StockClientB2BDTO();
			StockClientB2BConverter.stockClientB2BToDto(clientB2b.getStocks().get(i), stockDTO);
			stocksDTO.add(stockDTO);
		}
		}
		
		
		clientB2BDTO.setVisibility(clientB2b.isVisibility())
		.setBusinessName(clientB2b.getBusinessName())
		.setCui(clientB2b.getCui())
		.setSubscribed(clientB2b.isSubscribed())
		.setStocks(stocksDTO)
		.setId(clientB2b.getId())
		.setAddress(clientB2b.getAddress())
		.setEmail(clientB2b.getEmail())
		.setPassword(clientB2b.getPassword())
		.setUsername(clientB2b.getUsername());
		
	}

}

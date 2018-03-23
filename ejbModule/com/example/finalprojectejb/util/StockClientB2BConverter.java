package com.example.finalprojectejb.util;

import java.util.ArrayList;
import java.util.List;

import com.example.finalprojectejb.dto.ClientB2BDTO;
import com.example.finalprojectejb.dto.StockClientB2BDTO;
import com.example.finalprojectejb.dto.StockSupplierDTO;
import com.example.finalprojectejb.model.ClientB2B;
import com.example.finalprojectejb.model.StockClientB2B;
import com.example.finalprojectejb.model.StockSupplier;

public class StockClientB2BConverter {
	public static void dtoToStockClientB2B(StockClientB2BDTO stockClientB2BDTO, StockClientB2B stockClientB2B) {
		

		List<StockSupplier> supplierStocks=new ArrayList<StockSupplier>();
		
		if(stockClientB2BDTO.getSupplierStocks()!= null) {
			for(int i=0;i<stockClientB2BDTO.getSupplierStocks().size();i++) {
				StockSupplier stockSupplier=new StockSupplier();
				StockSupplierConverter.dtoToStockSupplier(stockClientB2BDTO.getSupplierStocks().get(i), stockSupplier);
				supplierStocks.add(stockSupplier);
			}
		}
		
		stockClientB2B.setId(stockClientB2BDTO.getId())
		.setActive(stockClientB2BDTO.isActive())
		.setLimitQuantity(stockClientB2BDTO.getLimitQuantity())
		.setPrice(stockClientB2BDTO.getPrice())
		.setQuantity(stockClientB2BDTO.getQuantity())
		.setSupplierStocks(supplierStocks);
			
		ClientB2B clientB2B=new ClientB2B();
		if(stockClientB2BDTO.getClientB2B()!=null) {
			ClientB2BConverter.dtoToClientB2B(stockClientB2BDTO.getClientB2B(), clientB2B);
			stockClientB2B.setClientB2B(clientB2B);
		}
		
		

		}

		public static void stockClientB2BToDto( StockClientB2B stockClientB2B, StockClientB2BDTO stockClientB2BDTO) {
			
		
		
		List<StockSupplierDTO> supplierStocksDTO=new ArrayList<StockSupplierDTO>();
		
		if(stockClientB2BDTO.getSupplierStocks()!=null) {
			for(int i=0;i<stockClientB2BDTO.getSupplierStocks().size();i++) {
				StockSupplierDTO stockSupplierDTO=new StockSupplierDTO();
				StockSupplierConverter.stockSupplierToDto(stockClientB2B.getSupplierStocks().get(i), stockSupplierDTO);
				supplierStocksDTO.add(stockSupplierDTO);
			}
		}
			
		stockClientB2BDTO.setId(stockClientB2B.getId())
				.setActive(stockClientB2B.isActive())
				.setLimitQuantity(stockClientB2B.getLimitQuantity())
				.setPrice(stockClientB2B.getPrice())
				.setQuantity(stockClientB2B.getQuantity())
				.setSupplierStocks(supplierStocksDTO);
		
		ClientB2BDTO clientB2BDTO=new ClientB2BDTO();
		if(stockClientB2B.getClientB2B()!=null) {
			ClientB2BConverter.clientB2BToDto(stockClientB2B.getClientB2B(), clientB2BDTO);
			stockClientB2BDTO.setClientB2B(clientB2BDTO);
		}
		}

}

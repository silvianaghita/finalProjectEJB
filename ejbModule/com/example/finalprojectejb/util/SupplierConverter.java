package com.example.finalprojectejb.util;

import java.util.ArrayList;
import java.util.List;
import com.example.finalprojectejb.dto.StockSupplierDTO;
import com.example.finalprojectejb.dto.SupplierDTO;
import com.example.finalprojectejb.model.StockSupplier;
import com.example.finalprojectejb.model.Supplier;

public class SupplierConverter {
public static void dtoToSupplier(SupplierDTO supplierDTO, Supplier supplier) {
		
		List<StockSupplier> stocks=new ArrayList<StockSupplier>();
		
		if(supplierDTO.getStocks()!=null) {
			for(int i=0;i<supplierDTO.getStocks().size();i++) {
				StockSupplier stock=new StockSupplier();
				StockSupplierConverter.dtoToStockSupplier(supplierDTO.getStocks().get(i), stock);
				stocks.add(stock);
			}
		}
	
		supplier.setVisibility(supplierDTO.isVisibility())
		    .setAge(supplierDTO.getAge())
		    .setWineCellarName(supplierDTO.isWineCellarName())
		    .setStocks(stocks)
		    .setId(supplierDTO.getId())
			.setAddress(supplierDTO.getAddress())
			.setEmail(supplierDTO.getEmail())
			.setPassword(supplierDTO.getPassword())
			.setUsername(supplierDTO.getUsername());
	}

	public static void supplierToDto(Supplier supplier, SupplierDTO supplierDTO) {
         List<StockSupplierDTO> stocksDTO=new ArrayList<StockSupplierDTO>();
		if(supplier.getStocks()!=null) {
			for(int i=0;i<supplier.getStocks().size();i++) {
				StockSupplierDTO stockDTO=new StockSupplierDTO();
				StockSupplierConverter.stockSupplierToDto(supplier.getStocks().get(i), stockDTO);
				stocksDTO.add(stockDTO);
			}
		}
	
		supplierDTO.setVisibility(supplier.isVisibility())
		    .setAge(supplier.getAge())
		    .setWineCellarName(supplier.isWineCellarName())
		    .setStocks(stocksDTO)
		    .setId(supplier.getId())
			.setAddress(supplier.getAddress())
			.setEmail(supplier.getEmail())
			.setPassword(supplier.getPassword())
			.setUsername(supplier.getUsername());
	}

}

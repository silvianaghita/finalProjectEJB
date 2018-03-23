package com.example.finalprojectejb.util;

import java.util.ArrayList;
import java.util.List;

import com.example.finalprojectejb.dto.StockSupplierDTO;
import com.example.finalprojectejb.dto.WineDTO;
import com.example.finalprojectejb.model.StockSupplier;
import com.example.finalprojectejb.model.Wine;

public class WineConverter {
	public static void dtoToWine(WineDTO wineDTO, Wine wine) {
		
		List<StockSupplier> stocks=new ArrayList<StockSupplier>();
		
		if(wineDTO.getSupplierStocks()!= null) {
			for(int i=0;i<wineDTO.getSupplierStocks().size();i++) {
				StockSupplier stock=new StockSupplier();
				StockSupplierConverter.dtoToStockSupplier(wineDTO.getSupplierStocks().get(i), stock);
				stocks.add(stock);
			}
		}
			
			wine.setId(wineDTO.getId())
				.setDescription(wineDTO.getDescription())
				.setType(wineDTO.getType())
				.setName(wineDTO.getName())
				.setVariety(wineDTO.getVariety())
				.setYear(wineDTO.getYear())
				.setSupplierStocks(stocks);
		}

		public static void wineToDto(Wine wine, WineDTO wineDTO) {
			  List<StockSupplierDTO> stocksDTO=new ArrayList<StockSupplierDTO>();
				
			  if(wine.getSupplierStocks()!= null) {
				for(int i=0;i<wine.getSupplierStocks().size();i++) {
					StockSupplierDTO stockDTO=new StockSupplierDTO();
					StockSupplierConverter.stockSupplierToDto(wine.getSupplierStocks().get(i), stockDTO);
					stocksDTO.add(stockDTO);
				}
			  }
		
				wineDTO.setId(wine.getId())
					.setDescription(wine.getDescription())
					.setType(wine.getType())
					.setName(wine.getName())
					.setVariety(wine.getVariety())
					.setYear(wine.getYear())
					.setSupplierStocks(stocksDTO);
		}

}

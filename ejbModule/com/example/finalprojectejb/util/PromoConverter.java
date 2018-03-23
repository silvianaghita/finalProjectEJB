package com.example.finalprojectejb.util;

import com.example.finalprojectejb.dto.PromoDTO;
import com.example.finalprojectejb.dto.StockSupplierDTO;
import com.example.finalprojectejb.model.Promo;
import com.example.finalprojectejb.model.StockSupplier;

public class PromoConverter {

public static void dtoToPromo(PromoDTO promoDTO, Promo promo) {
		
		promo.setId(promoDTO.getId())
		.setDiscount(promoDTO.getDiscount())
		.setStartDate(promoDTO.getStartDate())
		.setEndDate(promoDTO.getEndDate());
		
		StockSupplier stockSupplier=new StockSupplier();
		if(promoDTO.getStockSupplier()!=null) {
			StockSupplierConverter.dtoToStockSupplier(promoDTO.getStockSupplier(), stockSupplier);
			promo.setStockSupplier(stockSupplier);
		}
		
	
	}

	public static void promoToDto(Promo promo, PromoDTO promoDTO) {
		
		promoDTO.setId(promo.getId())
		.setDiscount(promo.getDiscount())
		.setStartDate(promo.getStartDate())
		.setEndDate(promo.getEndDate());

		
		StockSupplierDTO stockSupplierDTO=new StockSupplierDTO();
		if(promo.getStockSupplier()!=null) {
			StockSupplierConverter.stockSupplierToDto(promo.getStockSupplier(), stockSupplierDTO);
			promoDTO.setStockSupplier(stockSupplierDTO);
		}
	}
}

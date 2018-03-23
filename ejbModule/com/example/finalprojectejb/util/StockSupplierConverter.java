package com.example.finalprojectejb.util;

import java.util.ArrayList;
import java.util.List;

import com.example.finalprojectejb.dto.PromoDTO;
import com.example.finalprojectejb.dto.StockClientB2BDTO;
import com.example.finalprojectejb.dto.StockSupplierDTO;
import com.example.finalprojectejb.dto.SupplierDTO;
import com.example.finalprojectejb.dto.WineDTO;
import com.example.finalprojectejb.model.Promo;
import com.example.finalprojectejb.model.StockClientB2B;
import com.example.finalprojectejb.model.StockSupplier;
import com.example.finalprojectejb.model.Supplier;
import com.example.finalprojectejb.model.Wine;

public class StockSupplierConverter {

	
	public static void dtoToStockSupplier(StockSupplierDTO stockSupplierDTO, StockSupplier stockSupplier) {

		
		
		List<Promo> promotions=new ArrayList<Promo>();
		if(stockSupplierDTO.getPromotions()!=null) {
			for(int i=0;i<stockSupplierDTO.getPromotions().size();i++) {
				Promo promo=new Promo();
				PromoConverter.dtoToPromo(stockSupplierDTO.getPromotions().get(i), promo);
				promotions.add(promo);
			}
		}

		stockSupplier.setId(stockSupplierDTO.getId())
			.setPrice(stockSupplierDTO.getPrice())
			.setQuantity(stockSupplierDTO.getQuantity())
			.setPromotions(promotions);
		
		StockClientB2B stockClientB2B=new StockClientB2B();
		if(stockSupplierDTO.getStockClientB2B()!=null) {
			StockClientB2BConverter.dtoToStockClientB2B(stockSupplierDTO.getStockClientB2B(), stockClientB2B);
			stockSupplier.setStockClientB2B(stockClientB2B);
		}
		
		Supplier supplier=new Supplier();
		if(stockSupplierDTO.getSupplier()!=null) {
			SupplierConverter.dtoToSupplier(stockSupplierDTO.getSupplier(),supplier);
			stockSupplier.setSupplier(supplier);
		}
		
		Wine wine =new Wine();
		if(stockSupplierDTO.getWine()!=null) {
			WineConverter.dtoToWine(stockSupplierDTO.getWine(), wine);
			stockSupplier.setWine(wine);
		}
	}

	public static void stockSupplierToDto(StockSupplier stockSupplier, StockSupplierDTO stockSupplierDTO) {
		
		
		List<PromoDTO> promotionsDTO=new ArrayList<PromoDTO>();
		if(stockSupplier.getPromotions()!=null) {
			for(int i=0;i<stockSupplier.getPromotions().size();i++) {
				PromoDTO promoDTO=new PromoDTO();
				PromoConverter.promoToDto(stockSupplier.getPromotions().get(i), promoDTO);
				promotionsDTO.add(promoDTO);
			}
		}

		stockSupplierDTO.setId(stockSupplier.getId())
			.setPrice(stockSupplier.getPrice())
			.setQuantity(stockSupplier.getQuantity())
			.setPromotions(promotionsDTO);
		
		StockClientB2BDTO stockClientB2BDTO =new StockClientB2BDTO();
		if(stockSupplier.getStockClientB2B()!=null) {
			StockClientB2BConverter.stockClientB2BToDto(stockSupplier.getStockClientB2B(), stockClientB2BDTO);
			stockSupplierDTO.setStockClientB2B(stockClientB2BDTO);
		}
		
		SupplierDTO supplierDTO=new SupplierDTO();
		if(stockSupplier.getSupplier()!=null) {
			SupplierConverter.supplierToDto(stockSupplier.getSupplier(),supplierDTO);
			stockSupplierDTO.setSupplier(supplierDTO);
		}
		
		WineDTO wineDTO =new WineDTO();
		if(stockSupplier.getWine()!=null) {
			WineConverter.wineToDto(stockSupplier.getWine(), wineDTO);
			stockSupplierDTO.setWine(wineDTO);
		}
	}
}

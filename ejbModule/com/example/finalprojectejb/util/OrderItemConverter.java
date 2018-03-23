package com.example.finalprojectejb.util;

import com.example.finalprojectejb.dto.ClientOrderDTO;
import com.example.finalprojectejb.dto.OrderItemDTO;
import com.example.finalprojectejb.dto.StockClientB2BDTO;
import com.example.finalprojectejb.model.ClientOrder;
import com.example.finalprojectejb.model.OrderItem;
import com.example.finalprojectejb.model.StockClientB2B;

public class OrderItemConverter {
	
public static void dtoToOrderItem(OrderItemDTO orderItemDTO, OrderItem orderItem) {
		
		orderItem.setId(orderItemDTO.getId())
		.setPrice(orderItemDTO.getPrice())
		.setQuantity(orderItemDTO.getQuantity());
		

		ClientOrder order = new ClientOrder();
		if(orderItemDTO.getOrder()!=null) {
			ClientOrderConverter.dtoToClientOrder(orderItemDTO.getOrder(), order);
			orderItem.setOrder(order);
		}

		StockClientB2B stock = new StockClientB2B();
		if(orderItemDTO.getStockClientB2B()!=null) {
			StockClientB2BConverter.dtoToStockClientB2B(orderItemDTO.getStockClientB2B(), stock);
			orderItem.setStockClientB2B(stock);
		}

		

	}

	public static void orderItemToDto(OrderItem orderItem, OrderItemDTO orderItemDTO) {
		
		orderItemDTO.setId(orderItem.getId())
		.setPrice(orderItem.getPrice())
		.setQuantity(orderItem.getQuantity());
		
		
		ClientOrderDTO orderDTO = new ClientOrderDTO();
	    if(orderItem.getOrder()!=null) {
	    	ClientOrderConverter.clientOrderToDto(orderItem.getOrder(), orderDTO);
	    	orderItemDTO.setOrder(orderDTO);
	    }

		StockClientB2BDTO stockDTO = new StockClientB2BDTO();
		if(orderItem.getStockClientB2B()!=null) {
			StockClientB2BConverter.stockClientB2BToDto(orderItem.getStockClientB2B(), stockDTO);
			orderItemDTO.setStockClientB2B(stockDTO);
		}

		
	
	}

}

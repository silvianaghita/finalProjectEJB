package com.example.finalprojectejb.util;

import java.util.ArrayList;
import java.util.List;

import com.example.finalprojectejb.dto.ClientB2CDTO;
import com.example.finalprojectejb.dto.ClientOrderDTO;
import com.example.finalprojectejb.dto.OrderItemDTO;
import com.example.finalprojectejb.model.ClientB2C;
import com.example.finalprojectejb.model.ClientOrder;
import com.example.finalprojectejb.model.OrderItem;

public class ClientOrderConverter {
	
	public static void dtoToClientOrder(ClientOrderDTO clientOrderDTO, ClientOrder clientOrder) {
		
	    List<OrderItem> orderItems=new ArrayList<OrderItem>();
	    
	    if(clientOrderDTO.getOrderItems()!=null) {
	    for(int i=0;i<clientOrderDTO.getOrderItems().size();i++) {
	    	OrderItem item=new OrderItem();
	    	OrderItemConverter.dtoToOrderItem(clientOrderDTO.getOrderItems().get(i), item);
	    	orderItems.add(item);
	    }
	    }
	    
	    clientOrder.setId(clientOrderDTO.getId())
		.setDate(clientOrderDTO.getDate())
		.setOrderNumber(clientOrderDTO.getOrderNumber())
		.setOrderItems(orderItems);
		
		ClientB2C clientB2C=new ClientB2C();
		if(clientOrderDTO.getClientB2C()!=null) {
			ClientB2CConverter.dtoToClientB2C(clientOrderDTO.getClientB2C(), clientB2C);
			clientOrder.setClientB2C(clientB2C);
		}
		
		
		
	}

	public static void clientOrderToDto( ClientOrder clientOrder,ClientOrderDTO clientOrderDTO)  {
          List<OrderItemDTO> orderItemsDTO=new ArrayList<OrderItemDTO>();
          
          if(clientOrder.getOrderItems()!=null) {
        	  for(int i=0;i<clientOrder.getOrderItems().size();i++) {
  	    	OrderItemDTO itemDTO=new OrderItemDTO();
  	    	OrderItemConverter.orderItemToDto(clientOrder.getOrderItems().get(i), itemDTO);
  	    	orderItemsDTO.add(itemDTO);
        	  }
          }
          
       clientOrderDTO.setId(clientOrder.getId())
  		.setDate(clientOrder.getDate())
  		.setOrderNumber(clientOrder.getOrderNumber())
  		.setOrderItems(orderItemsDTO);
		
		ClientB2CDTO clientB2CDTO=new ClientB2CDTO();
		if(clientOrder.getClientB2C()!=null) {
			ClientB2CConverter.clientB2CToDto(clientOrder.getClientB2C(), clientB2CDTO);
			clientOrderDTO.setClientB2C(clientB2CDTO);
		}
		
		
	}

}

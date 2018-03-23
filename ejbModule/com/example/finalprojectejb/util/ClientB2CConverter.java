package com.example.finalprojectejb.util;

import java.util.ArrayList;
import java.util.List;

import com.example.finalprojectejb.dto.ClientB2CDTO;
import com.example.finalprojectejb.dto.ClientOrderDTO;
import com.example.finalprojectejb.model.ClientB2C;
import com.example.finalprojectejb.model.ClientOrder;

public class ClientB2CConverter {
	
public static void dtoToClientB2C(ClientB2CDTO clientB2CDTO, ClientB2C clientB2c) {
		
		List<ClientOrder> orders=new ArrayList<ClientOrder>();
		
		if(clientB2CDTO.getOrders()!= null) {
		for(int i=0;i<clientB2CDTO.getOrders().size();i++) {
			ClientOrder order=new ClientOrder();
			ClientOrderConverter.dtoToClientOrder(clientB2CDTO.getOrders().get(i), order);
			orders.add(order);
		}
		}
		
		clientB2c.setCnp(clientB2CDTO.getCnp())
		.setFirstName(clientB2CDTO.getFirstName())
		.setLastName(clientB2CDTO.getLastName())
		.setRegisterDate(clientB2CDTO.getRegisterDate())
		.setOrders(orders)
		.setId(clientB2CDTO.getId())
		.setAddress(clientB2CDTO.getAddress())
		.setEmail(clientB2CDTO.getEmail())
		.setPassword(clientB2CDTO.getPassword())
		.setUsername(clientB2CDTO.getUsername());
		
	}

	public static void clientB2CToDto(ClientB2C clientB2c,ClientB2CDTO clientB2CDTO)  {
		List<ClientOrderDTO> orders=new ArrayList<ClientOrderDTO>();
		
		if(clientB2c.getOrders()!= null) {
			for(int i=0;i<clientB2c.getOrders().size();i++) {
			ClientOrderDTO orderDTO=new ClientOrderDTO();
			ClientOrderConverter.clientOrderToDto(clientB2c.getOrders().get(i), orderDTO);
			orders.add(orderDTO);
			}
		}
		
		clientB2CDTO.setCnp(clientB2c.getCnp())
		.setFirstName(clientB2c.getFirstName())
		.setLastName(clientB2c.getLastName())
		.setRegisterDate(clientB2c.getRegisterDate())
		.setOrders(orders)
		.setId(clientB2c.getId())
		.setAddress(clientB2c.getAddress())
		.setEmail(clientB2c.getEmail())
		.setPassword(clientB2c.getPassword())
		.setUsername(clientB2c.getUsername());

	}


}

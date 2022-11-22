package com.devsuperior.services;

import org.springframework.stereotype.Service;

import com.devsuperior.entities.Order;

@Service
public class OrderService {
	
	private ShipmentService shipmentService;
	
	public OrderService(ShipmentService shipmentService) {
		this.shipmentService = shipmentService;
	}
	
	public double total(Order order) {
		return order.getBasic()*
				(1-(order.getDiscount()/100))+
				shipmentService.shipment(order);
	}

}

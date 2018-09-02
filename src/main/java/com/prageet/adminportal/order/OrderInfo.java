package com.prageet.adminportal.order;

import java.util.List;

import javax.persistence.ElementCollection;

import com.prageet.adminportal.orderDetails.OrderDetails;

public class OrderInfo {
	
	private Order order;
	@ElementCollection
    private List<OrderDetails> orderDetails;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
    
	
    
	
}

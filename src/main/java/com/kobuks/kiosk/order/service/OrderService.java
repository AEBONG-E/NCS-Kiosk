package com.kobuks.kiosk.order.service;

import java.util.List;

import com.kobuks.kiosk.menu.domain.Menu;
import com.kobuks.kiosk.order.domain.Order;

public interface OrderService {
	
	public void saveOrder(Order order);
	
	public List<Order> findAllOrders();

}

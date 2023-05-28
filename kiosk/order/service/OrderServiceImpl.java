package com.kobuks.kiosk.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kobuks.kiosk.menu.domain.Menu;
import com.kobuks.kiosk.order.dao.OrderDao;
import com.kobuks.kiosk.order.domain.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired // 이거없으면 500에러뜸. 왜지?
	private OrderDao orderDao;

	@Override
	public void saveOrder(Order order) {
		orderDao.saveOrder(order);
		
	}
	
	// 전체주문내역조회
	@Override
	public List<Order> findAllOrders() {
		return orderDao.findAllOrders();
	}

	
}

//	@Override
//	public void addOrder(Menu menu) {
//		orderDao.addOrder(menu);
//
//	}
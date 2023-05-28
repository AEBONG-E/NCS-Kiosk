package com.kobuks.kiosk.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kobuks.kiosk.order.command.OrderCommand;
import com.kobuks.kiosk.order.domain.Order;
import com.kobuks.kiosk.order.service.OrderService;

@Controller
@RequestMapping("/admin")
public class OrderController {
	
	private final OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
		
	// 주문하기
	@GetMapping("")
	public String saveOrder(Model model) {
		model.addAttribute("order", new Order());
		return "";
	}
	@PostMapping
	public String SaveOrder(@ModelAttribute("order")OrderCommand order, Model model) {
		
		Order o = new Order();
		o.setMenuId(order.getMenuId());
		
		
		
		return "";
	}
	
	
	
	// 전체주문내역 조회
	@RequestMapping(value = "/order_list")
	public String findAllOrders(Model model) {
		List<Order> list = orderService.findAllOrders();
		model.addAttribute("orderList", list); // 뷰EL로 접근가능 데이터 추가
		return "admin/order_list";
		
	}

}

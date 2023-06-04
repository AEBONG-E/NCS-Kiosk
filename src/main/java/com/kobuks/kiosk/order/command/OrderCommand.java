package com.kobuks.kiosk.order.command;

import com.kobuks.kiosk.cart.domain.Cart;
import com.kobuks.kiosk.menu.domain.Menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 주문 정보를 저장하는 클래스
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class OrderCommand {
	
	
    public OrderCommand() {
		// TODO Auto-generated constructor stub
	}

	private Menu menu;
	
	private long menuId;

	private long orderId;   //주문번호

    private Cart cart;
    
    private String regDate;


}

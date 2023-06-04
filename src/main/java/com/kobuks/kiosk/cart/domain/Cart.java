package com.kobuks.kiosk.cart.domain;

import com.kobuks.kiosk.order.domain.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 고객이 주문한 메뉴 정보를 저장하는 클래스
 */
@Getter
@Setter
@AllArgsConstructor
public class Cart {
    private List<OrderItem> orderList;

}

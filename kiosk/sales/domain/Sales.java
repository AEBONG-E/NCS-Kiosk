package com.kobuks.kiosk.sales.domain;

import com.kobuks.kiosk.order.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * 메뉴별 판매량 정보를 저장
 * 영수증 정보를 저장 하는 클래스
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Sales {
    public Sales() {
		// TODO Auto-generated constructor stub
	}
	private Order order;    //주문번호, 주문날짜/시간, 주문 메뉴명
    
	private long salesId;
    private double payment;    //결제금액
    private int salesCount;
    private String regDate;
}

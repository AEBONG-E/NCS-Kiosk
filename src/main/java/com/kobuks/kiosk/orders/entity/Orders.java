package com.kobuks.kiosk.orders.entity;

import com.kobuks.kiosk.cart.entity.Cart;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 장바구니의 데이터를 넘겨받아 주문번호와 주문일자의 데이터와 합쳐
 * 판매정보로 데이터를 넘기는 클래스
 */
@Entity
@Table(name = "orders")
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ordersDate;

}


package com.kobuks.kiosk.item.entity;

import com.kobuks.kiosk.cart.entity.Cart;
import com.kobuks.kiosk.menu.entity.Menu;
import com.kobuks.kiosk.orders.entity.Orders;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 주문정보를 가지는 클래스
 * Menu 클래스와 1:1 매핑 관계
 * Cart 클래스와 1:1 매핑 관계
 */
@Entity
@Table(name = "item")
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;
    @Column(nullable = false)
    private int quantity;

}


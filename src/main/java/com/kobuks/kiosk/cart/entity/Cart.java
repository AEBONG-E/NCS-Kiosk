package com.kobuks.kiosk.cart.entity;

import com.kobuks.kiosk.item.entity.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 주문정보를 리스트로 받아 여러개 등록 하고
 * 담아서 주문할 때 모든 cart 의 데이터를 넘겨주는 클래스
 */
@Entity
@Table(name = "cart")
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Item> items;

    // Getters and setters
}


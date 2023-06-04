package com.kobuks.kiosk.sales.entity;

import com.kobuks.kiosk.orders.entity.Orders;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 주문의 모든 데이터를 넘겨받아서
 * 사용자가 결제를 하면 판매일자와 총판매금액 판매정보를 저장하는 클래스
 * 주문과 1:1 매핑 관계를 갖는다
 *
 */
@Entity
@Table(name = "sales")
@Getter
@Setter
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp salesDate;    //판매 일자

    @Column(nullable = false)
    private double totalAmount; //총 판매금액

}


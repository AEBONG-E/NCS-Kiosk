package com.kobuks.kiosk.menu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 메뉴의 모든 정보를 지니고 있는 최상위 entity
 * 메뉴이미지, 주문정보와 1:n 매핑관계를 가짐
 */
@Entity
@Table(name = "menu")
@Getter
@Setter
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100)
    private MenuType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100)
    private MenuSize size;

    @Enumerated(EnumType.STRING)
    @Column(name = "menu_options", nullable = false, length = 100)
    private MenuOption options;

    @Column(nullable = false)
    private int stock;

    @Column(name = "reg_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp regDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_img_id")
    private MenuImg menuImg;

}


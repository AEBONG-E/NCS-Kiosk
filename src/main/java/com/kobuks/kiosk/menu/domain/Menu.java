package com.kobuks.kiosk.menu.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * 카페에서 제공하는 메뉴 정보를 저장하는 클래스
 */
@Getter
@Setter
@AllArgsConstructor
public class Menu {
	
    public Menu() {
		// TODO Auto-generated constructor stub
	}
	private long menuId;
    private String menuName;
    private double price;
    private String menuImg;
    private String menuType;  //COFFEE, DRINK, DESSERT
    private String menuSize;
    private boolean menuOption; //true : hot , false : ice
    private int stock;  //재고
    private Timestamp regDate;
}

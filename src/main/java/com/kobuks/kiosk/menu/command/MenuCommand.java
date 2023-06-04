package com.kobuks.kiosk.menu.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuCommand {
	
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

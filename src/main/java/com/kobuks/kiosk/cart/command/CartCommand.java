package com.kobuks.kiosk.cart.command;

import java.sql.Timestamp;

public class CartCommand {
    private long menuId;
    private String menuName;
    private double price;
    private String menuSize;
    private boolean menuOption;
    private int menuCount;
    private Timestamp regDate;
}

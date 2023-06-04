package com.kobuks.kiosk.menu.dto;

import com.kobuks.kiosk.menu.entity.MenuImg;
import com.kobuks.kiosk.menu.entity.MenuOption;
import com.kobuks.kiosk.menu.entity.MenuSize;
import com.kobuks.kiosk.menu.entity.MenuType;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class MenuDTO {
    private Long id;
    private String name;
    private double price;
    private MenuType type;
    private MenuSize size;
    private MenuOption option;
    private int stock;
    private Timestamp regDate;
    private Long menuImgId; // Add this field
    private String imageName;
    private String imageUrl;
    private String originalFileName; // Add this field
    private String imagePath; // Add this field
    private byte[] imageBytes; // Add this field
}



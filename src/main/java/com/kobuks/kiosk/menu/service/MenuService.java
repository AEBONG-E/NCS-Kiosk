package com.kobuks.kiosk.menu.service;

import com.kobuks.kiosk.menu.domain.Menu;

import java.util.List;

public interface MenuService {

    public List<Menu> findAllMenuList();

    public Menu findMenuByMenuId();

    public List<Menu> findMenuListByMenuType();
}

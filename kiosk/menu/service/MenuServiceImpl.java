package com.kobuks.kiosk.menu.service;

import com.kobuks.kiosk.menu.domain.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements  MenuService{
    @Override
    public List<Menu> findAllMenuList() {
        return null;
    }

    @Override
    public Menu findMenuByMenuId() {
        return null;
    }

    @Override
    public List<Menu> findMenuListByMenuType() {
        return null;
    }
}

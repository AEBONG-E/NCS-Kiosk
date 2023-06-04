package com.kobuks.kiosk.menu.dao;

import com.kobuks.kiosk.menu.domain.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuDao implements MenuRepository {
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

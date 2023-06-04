package com.kobuks.kiosk.cart.service;

import com.kobuks.kiosk.cart.domain.Cart;

public interface CartService {

    public void addCart();

    public void removeCart();

    public void updateCart();

    public void initCart();

    public Cart oderMenu();
}

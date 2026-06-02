package com.dailycodework.buynowdotcom.service.cart;

import com.dailycodework.buynowdotcom.model.Cart;
import com.dailycodework.buynowdotcom.model.User;

import java.math.BigDecimal;

public interface ICartService
{
    Cart getCart(Long carId);
    Cart getCartByUserId(Long userId);
    void clearCart(Long cartId);
    Cart initialiseNewCartForUser(User user);
    BigDecimal getTotalPrice(Long cartId);
}

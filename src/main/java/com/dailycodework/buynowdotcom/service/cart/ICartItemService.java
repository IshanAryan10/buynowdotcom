package com.dailycodework.buynowdotcom.service.cart;

import com.dailycodework.buynowdotcom.model.CartItem;

public interface ICartItemService
{
    void addItemToCart(Long cartId, Long ProductId, int quantity);
    void removeItemFromCart(Long cartId, Long productId);
    void updateItemQuantity(Long cartId, Long ProductId, int quantity);
    CartItem getCartItem(Long cartId, Long productId);

}

package com.system.helmethub.service;

import com.system.helmethub.dto.CartDto;
import com.system.helmethub.entity.Cart;

import java.util.List;

public interface CartService {

    void add(CartDto cartDto);

    List<Cart> getCartByActiveUser( );

    void delete(int id);

    void edit(CartDto cartDto);
}

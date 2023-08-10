package com.system.helmethub.service.impl;

import com.system.helmethub.dto.CartDto;
import com.system.helmethub.entity.Cart;
import com.system.helmethub.entity.Product;
import com.system.helmethub.entity.User;
import com.system.helmethub.repo.CartRepo;
import com.system.helmethub.service.CartService;
import com.system.helmethub.service.ProductService;
import com.system.helmethub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepo cartRepo;
    private final ProductService productService;
    private final UserService userService;

    @Override
    public void add(CartDto cartDto) {
        Cart cart = new Cart();
        Product product = productService.getProduct(cartDto.getProductId()).get();
        cart.setProduct(product);

        User user = userService.getActiveUser().get();
        cart.setUser(user);

        cart.setQuantity(cartDto.getQuantity());

        int total = product.getProductPrice() * cartDto.getQuantity();
        cart.setTotalPrice(total);

        cart.setSize(cartDto.getSize());

        cart.setStatus("Pending");
        cartRepo.save(cart);
    }

    @Override
    public List<Cart> getCartByActiveUser() {
        User user = userService.getActiveUser().get();
        return cartRepo.findByUser(user.getId());
    }

    @Override
    public void delete(int id) {
        cartRepo.deleteById(id);
    }

    @Override
    public void edit(CartDto cartDto) {
        Cart cart = cartRepo.findById(cartDto.getId()).get();
        cart.setQuantity(cartDto.getQuantity());
        int total = cart.getProduct().getProductPrice() * cartDto.getQuantity();
        cart.setTotalPrice(total);
        cartRepo.save(cart);
    }
}

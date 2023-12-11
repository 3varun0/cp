package com.ms.project3.cart.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cart")
public class CartSystemController {
    List<String> cart;

    CartSystemController() {
        cart = new ArrayList<>();
    }

    @PostMapping("/{product}")
    public String addProductToCart (@PathVariable String product) {
        cart.add(product);
        return product;
    }

    @PutMapping("/{index}/{product}")
    public String updateProductInCart (@PathVariable int index, @PathVariable String product) {

        return cart.set(index, product);
    }

    @DeleteMapping("/{index}")
    public String removeProductFromCart (@PathVariable int index) {
        return cart.remove(index);
    }

    @GetMapping("/{index}")
    public String getProductFromCart(@PathVariable int index) {
        return cart.get(index);
    }
}

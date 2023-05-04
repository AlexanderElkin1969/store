package com.example.store.model;

import com.example.store.service.BasketService;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
@SessionScope
public class Basket {

    public List<Product> basketList = new ArrayList<>();

    private final BasketService basketService;

    public Basket(BasketService basketService) {
        this.basketService = basketService;
    }

    public void add(Product product) {
        basketList.add(product);
    }

    public List<Product> getBasketList() {
        return Collections.unmodifiableList(basketList);
    }
}

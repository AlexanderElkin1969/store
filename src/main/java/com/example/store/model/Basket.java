package com.example.store.model;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
@SessionScope
public class Basket {
    @PostConstruct
    public void init(){
        System.out.println("Корзина создана.");
    }

    private final List<Product> basketList = new ArrayList<>();

    public void add(Product product) {
        basketList.add(product);
    }

    public List<Product> getBasketList() {
        return List.copyOf(basketList);
    }


}


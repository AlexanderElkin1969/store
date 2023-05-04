package com.example.store.controller;

import com.example.store.model.Product;
import com.example.store.service.BasketService;
import com.example.store.service.StoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@RestController
@SessionScope
@RequestMapping("/store/order/")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService){
        this.basketService = basketService;
    }

    @GetMapping(path ="add")
    @SessionScope
    public String addProductToBasket(@RequestParam("ID") String id,
                                     @RequestParam("quantity") int quantity){
        return basketService.add(id, quantity).toString() + " добавлен в корзину.";
    }

    @GetMapping(path ="get")
    @SessionScope
    public List<Product> getProductToBasket(){
        return basketService.get();
    }

}

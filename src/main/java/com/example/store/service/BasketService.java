package com.example.store.service;

import com.example.store.exeption.LittleProductExeption;
import com.example.store.exeption.ProductNotFoundExeption;
import com.example.store.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    @Autowired
    private Basket basket;

    private final StoreService storeService;

    public BasketService(StoreService storeService) {
        this.storeService = storeService;
    }

    public Product add(String id, int quantity) {
        Product order;
        Product product = storeService.find(id);
        if (product == null) {
            throw new ProductNotFoundExeption("Товар не найден. Проверьте правильность написания Артикула_товара.");
        }
        int balance = product.getQuantity() - quantity;
        if (balance >= 0) {
            order = new Product(id, product.getNameOfProduct(), quantity);
            basket.add(order);
            product.setQuantity(balance);
            return order;
        } else {
            throw new LittleProductExeption("Товар временно не доступен в данном объёме.");
        }
    }

    public List<Product> get() {
        return basket.getBasketList();
    }
}

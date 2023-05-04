package com.example.store.service;

import com.example.store.exeption.LittleProductExeption;
import com.example.store.exeption.ProductNotFoundExeption;
import com.example.store.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@SessionScope
public class BasketService {

    private final StoreService storeService;

    public BasketService(StoreService storeService){
        this.storeService = storeService;
    }

    private static List<Product> basket = new ArrayList<Product>();

    public Product add(String id, int quantity){
        Product product = storeService.find(id);
        if (product == null) {
            throw new ProductNotFoundExeption("Товар не найден. Проверьте правильность написания Артикула товара.");
        }
        int balance = product.getQuantity() - quantity;
        if (balance >= 0) {
            basket.add(new Product(id, product.getNameOfProduct(), quantity));
            product.setQuantity(balance);
            return basket.get(basket.size() - 1);
        }else {
            throw new LittleProductExeption("Товар не доступен в данном объёме.");
        }
    }

    public static List<Product> get(){
        return Collections.unmodifiableList(basket);
    }
}

package com.example.store.service;

import com.example.store.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StoreService {

    private static Map<String, Product> store = new HashMap<>(Map.of(
            "001", new Product("001", "product1", 10),
            "002", new Product("002", "product2", 10),
            "003", new Product("003", "product3", 10),
            "004", new Product("004", "product4", 10),
            "005", new Product("005", "product5", 10),
            "006", new Product("006", "product6", 10),
            "007", new Product("007", "product7", 10)
    ));

    public static Map<String, Product> getList() {
        return Map.copyOf(store);
    }

    public Product find(String id) {
        return store.get(id);
    }
}

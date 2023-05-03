package com.example.store.service;

import com.example.store.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StoreService {

    private static List<Product> store = new ArrayList<>(Arrays.asList(
            new Product("001", "product1", 10),
            new Product("002", "product2", 10),
            new Product("003", "product3", 10),
            new Product("004", "product4", 10),
            new Product("005", "product5", 10),
            new Product("006", "product6", 10),
            new Product("007", "product7", 10)
            ));

    public static List<Product> getList(){
        return Collections.unmodifiableList(store);
    }
}

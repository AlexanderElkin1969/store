package com.example.store.exeption;

public class ProductNotFoundExeption extends  RuntimeException {

    public ProductNotFoundExeption(String message) {
        super(message);
    }
}

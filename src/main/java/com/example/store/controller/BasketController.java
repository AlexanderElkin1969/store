package com.example.store.controller;

import com.example.store.exeption.LittleProductExeption;
import com.example.store.exeption.ProductNotFoundExeption;
import com.example.store.model.Product;
import com.example.store.service.BasketService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store/order/")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping(path = "add")
    public String addProductToBasket(@RequestParam("ID") String id,
                                     @RequestParam("quantity") int quantity) {
        return basketService.add(id, quantity).toString() + " добавлен в корзину.";
    }

    @GetMapping(path = "get")
    public List<Product> getProductToBasket() {
        return basketService.get();
    }

    @ExceptionHandler(LittleProductExeption.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String LittleProductExeption(LittleProductExeption e) {
        return e.getMessage();
    }

    @ExceptionHandler(ProductNotFoundExeption.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String ProductNotFoundExeption(ProductNotFoundExeption e) {
        return e.getMessage();
    }

}

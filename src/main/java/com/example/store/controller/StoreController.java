package com.example.store.controller;

import com.example.store.model.Product;
import com.example.store.service.StoreService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }


    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String hello() {
        return "<h1 style = \" color: green \">Добро пожаловать в наш интернет-магазин.</h1>" +
                "Для просмотра каталога товара воспользуйтесь командой /order.   " +
                "Для выбора товара воспользуйтесь командой /order/add?ID=Артикль_товара&quantity=количество_товара.   " +
                "Для просмотра выбранного товара воспользуйтесь командой /order/get.   ";
    }

    @GetMapping(path ="/order")
    public List<Product> getList(){
        return storeService.getList();
    }

}

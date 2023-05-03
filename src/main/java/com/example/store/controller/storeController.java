package com.example.store.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class storeController {

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String hello() {
        return "<h1 style = \" color: green \">Добро пожаловать в наш интернет-магазин.</h1>" +
                "Для просмотра каталога товара воспользуйтесь командой /order.   " +
                "Для выбора товара воспользуйтесь командой /order/add?ID=Артикль товара.   " +
                "Для просмотра выбранного товара воспользуйтесь командой /order/get.   ";
    }

}

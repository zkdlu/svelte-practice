package com.zkdlu.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shops")
public class ShopApi {
    private final ShopService shopService;

    @GetMapping
    public List<Shop> getShops() {
        return shopService.getShops();
    }
}

package com.zkdlu.shop.food;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/shops/*")
@RestController
public class FoodApi {
    @GetMapping("/{id}/foods")
    public void getFoods(@PathVariable("id") long shopId) {

    }
}

package com.zkdlu.shop.food;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/shops/*")
@RestController
public class FoodApi {
    @GetMapping("/{id}/foods")
    public List<Food> getFoods(@PathVariable("id") long shopId) {
        return List.of(
                new Food(
                        1L,
                        "음식",
                        1000,
                        "식사류",
                        "\uD83C\uDF63",
                        true
                )
        );
    }
}

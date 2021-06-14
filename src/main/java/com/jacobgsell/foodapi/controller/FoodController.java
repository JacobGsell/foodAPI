package com.jacobgsell.foodapi.controller;

import com.jacobgsell.foodapi.entity.Food;
import com.jacobgsell.foodapi.repository.FoodRepository;
import com.jacobgsell.foodapi.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodRepository foodRepository, FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> Index() {
        return foodService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> FindById(@PathVariable Long id) {
        Food food = foodService.findById(id);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @GetMapping("/random")
    public ResponseEntity<Food> FindRandom() {
        Food food = foodService.getRandom();
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

}

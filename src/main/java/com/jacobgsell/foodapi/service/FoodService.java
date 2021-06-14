package com.jacobgsell.foodapi.service;

import com.jacobgsell.foodapi.entity.Food;
import com.jacobgsell.foodapi.repository.FoodRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class FoodService {

    private FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public Food findById(Long id) {
        Optional<Food> food = foodRepository.findById(id);

        return food.get();
    }

    public Food getRandom() {
        List<Food> all = foodRepository.findAll();
        int i = ThreadLocalRandom.current().nextInt(0, all.size());
        return all.get(i);
    }
}

package com.jacobgsell.foodapi.repository;


import com.jacobgsell.foodapi.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {}

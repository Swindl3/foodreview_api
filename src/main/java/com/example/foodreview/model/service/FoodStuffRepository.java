package com.example.foodreview.model.service;

import com.example.foodreview.model.table.FoodStuff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodStuffRepository extends JpaRepository<FoodStuff,Integer> {

}

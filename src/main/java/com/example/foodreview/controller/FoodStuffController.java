package com.example.foodreview.controller;

import com.example.foodreview.model.bean.APIResponse;
import com.example.foodreview.model.service.FoodStuffRepository;
import com.example.foodreview.model.table.FoodStuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foodstuff")
public class FoodStuffController {

    @Autowired
    private FoodStuffRepository foodstuffRepository;

    @PostMapping(value = "/save")
    public Object save(FoodStuff foodstuff){
        APIResponse res = new APIResponse();
        System.out.println(foodstuff);
        foodstuffRepository.save(foodstuff);
        return  res;
    }

    @PostMapping(value = "/list")
    public Object list(){
        APIResponse res = new APIResponse();
        res.setData(foodstuffRepository.findAll());
        return  res;
    }

}

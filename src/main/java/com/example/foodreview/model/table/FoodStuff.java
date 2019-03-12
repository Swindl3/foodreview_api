package com.example.foodreview.model.table;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@Data
@Entity(name = "foodstuff")
public class FoodStuff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userid")
    private int userId;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int price;

    @Column(name = "create_date")
    private Date dateTime = new Date();
}

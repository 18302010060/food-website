package com.example.foodwebsite.Entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ReviewedDish {
    @Id
    private Long id;
    private Long reviewId;
    private String name;

}

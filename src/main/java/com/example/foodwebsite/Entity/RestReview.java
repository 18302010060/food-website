package com.example.foodwebsite.Entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class RestReview {
    @Id
    private Long id;
    private Long uid;
    private Long restId;
    private int anonymous;
    private int averagePrice;
    private double foodRating;
    private double serviceRating;
    private double ambienceRating;
    private int recommended;
    private String raw;

    public double getOverallRating() {
        return (foodRating + serviceRating + ambienceRating) / 3.0;
    }
}

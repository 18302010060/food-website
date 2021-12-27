package com.example.foodwebsite.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
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
    private String dishes;
    private String tags;

    public double getOverallRating() {
        return (foodRating + serviceRating + ambienceRating) / 3.0;
    }

}

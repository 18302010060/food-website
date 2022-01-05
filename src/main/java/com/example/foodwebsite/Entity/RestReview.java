package com.example.foodwebsite.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "rest_review")
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
    private Date createAt;

    @Transient
    private String nickname;

    public double getOverallRating() {
        return (foodRating + serviceRating + ambienceRating) / 3.0;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "reviewId")
    private List<SubReview> subReviews = new ArrayList<>();

}

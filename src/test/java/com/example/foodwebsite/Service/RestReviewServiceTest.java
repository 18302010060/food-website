package com.example.foodwebsite.Service;

import com.example.foodwebsite.Entity.RestReview;
import com.example.foodwebsite.Entity.SubReview;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestReviewServiceTest {
    @Autowired
    private RestReviewService restReviewService;

    @Test
    void createRestReview() {
        final RestReview review = new RestReview();
        review.setUid(1L);
        review.setRestId(1L);
        review.setAmbienceRating(6.7);
        review.setFoodRating(5.4);
        review.setServiceRating(8.9);
        review.setTags("delicious");
        review.setRaw("very delicious food!");
        restReviewService.createRestReview(1L, 1L, review);
    }

    @Test
    void selectReviewById() {
        restReviewService.selectReviewById(1L);
    }

    @Test
    void selectReviews() {
        restReviewService.selectReviews(1L, 0, 0, -1L, 10);
    }

    @Test
    void createSubReview() {
        final SubReview subReview = new SubReview();
        subReview.setRaw("you liar!!!!");
        restReviewService.createSubReview(1L, 2L, subReview);
    }
}
package com.example.foodwebsite.Controller;

import com.example.foodwebsite.Service.RestReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RestaurantController {
    private final RestReviewService restReviewService;

    @GetMapping("/user/{uid}/restaurant/recommended")
    public ResponseEntity<?> getRecommendedRestaurants(@PathVariable Long uid,
                                                       @RequestParam Long lastId,
                                                       @RequestParam(required = false, defaultValue = "0x7fffffff") Integer limit) {
        return ResponseEntity.ok(restReviewService.selectRecommendedRestaurants(uid, lastId, limit)
        );
    }
}

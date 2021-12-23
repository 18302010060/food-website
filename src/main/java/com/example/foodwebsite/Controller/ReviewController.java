package com.example.foodwebsite.Controller;


import com.example.foodwebsite.Entity.RestReview;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
public class ReviewController {
    @PostMapping("/restaurant/{restId}/review/{uid}")
    public ResponseEntity<?> createReview(@PathVariable Long restId, Long uid,
                                          @RequestBody RestReview detail) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/restaurant/{restId}/review")
    public ResponseEntity<?> getReviews(@PathVariable Long restId, @RequestParam Long lastId) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/user/{uid}/review")
    public ResponseEntity<?> getReviews(@PathVariable Long uid, @RequestParam Long anonymous, @RequestParam Long lastId) {
        return ResponseEntity.ok(null);
    }
}

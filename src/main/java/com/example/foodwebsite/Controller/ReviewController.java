package com.example.foodwebsite.Controller;


import com.example.foodwebsite.Entity.RestReview;
import com.example.foodwebsite.Entity.SubReview;
import com.example.foodwebsite.Service.RestReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ReviewController {
    private final RestReviewService restReviewService;

    @PostMapping("user/{uid}/restaurant/{restId}/review")
    public ResponseEntity<?> createReview(@PathVariable Long restId, @PathVariable Long uid,
                                          @RequestBody RestReview detail) {
        final boolean res = restReviewService.createRestReview(restId, uid, detail);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<?> getReview(@PathVariable Long id) {
        return ResponseEntity.ok(restReviewService.selectReviewById(id));
    }

    @GetMapping("/restaurant/{restId}/review")
    public ResponseEntity<?> getReviews(@PathVariable Long restId, @RequestParam Long lastId,
                                        @RequestParam(required = false, defaultValue = "0x7fffffff") Integer limit) {
        return ResponseEntity.ok(restReviewService.selectReviews(restId, lastId, limit));
    }

    @GetMapping("/user/{uid}/review")
    public ResponseEntity<?> getReviews(@PathVariable Long uid, Long anonymous, @RequestParam Long recommended,
                                        @RequestParam Long lastId,
                                        @RequestParam(required = false, defaultValue = "0x7fffffff") Integer limit) {
        return ResponseEntity.ok(restReviewService.
                selectReviews(uid, anonymous.intValue(), recommended.intValue(), lastId, limit)
        );
    }

    @PostMapping("user/{uid}/restaurant/review/{reviewId}/sub-review")
    public ResponseEntity<?> createSubReview(@PathVariable Long reviewId, @PathVariable Long uid,
                                             @RequestBody SubReview detail) {
        final boolean res = restReviewService.createSubReview(reviewId, uid, detail);
        return ResponseEntity.ok(res);
    }
}

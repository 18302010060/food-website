package com.example.foodwebsite.Service;

import com.example.foodwebsite.Entity.RestReview;
import com.example.foodwebsite.Entity.SubReview;
import com.example.foodwebsite.Repository.RestReviewRepository;
import com.example.foodwebsite.Repository.SubReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RestReviewService {
    private final RestReviewRepository restReviewRepository;
    private final SubReviewRepository subReviewRepository;

    public boolean createRestReview(Long restId, Long uid, RestReview review) {
        review.setRestId(restId);
        review.setUid(uid);
        restReviewRepository.save(review);
        return true;
    }

    public RestReview selectReviewById(Long id) {
        return restReviewRepository.findRestReviewById(id);
    }

    public List<RestReview> selectReviews(Long restId, Long lastId, int limit) {
        return restReviewRepository.findByRestIdAndIdGreaterThan(restId, lastId, Pageable.ofSize(limit));
    }

    public List<RestReview> selectReviews(Long uid, int anonymous, int recommended, Long lastId, int limit) {
        return restReviewRepository.findByUidAndAnonymousAndRecommendedAndIdGreaterThan(uid, anonymous, recommended, lastId, Pageable.ofSize(limit));
    }

    public boolean createSubReview(Long reviewId, Long uid, SubReview review) {
        review.setReviewId(reviewId);
        review.setUid(uid);
        subReviewRepository.save(review);
        return true;
    }

}

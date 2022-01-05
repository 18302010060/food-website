package com.example.foodwebsite.Service;

import com.example.foodwebsite.Domain.UidNickname;
import com.example.foodwebsite.Entity.RestReview;
import com.example.foodwebsite.Entity.SubReview;
import com.example.foodwebsite.Repository.RestReviewRepository;
import com.example.foodwebsite.Repository.SubReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RestReviewService {
    private final RestReviewRepository restReviewRepository;
    private final SubReviewRepository subReviewRepository;

    private final UserService userService;

    public boolean createRestReview(Long restId, Long uid, RestReview review) {
        review.setRestId(restId);
        review.setUid(uid);
        restReviewRepository.save(review);
        return true;
    }

    public RestReview selectReviewById(Long id) {
        final RestReview res = restReviewRepository.findRestReviewById(id);
        fillNicknames(Collections.singletonList(res));
        return res;
    }

    public List<RestReview> selectReviews(Long restId, Long lastId, int limit) {
        final List<RestReview> res = restReviewRepository.
                findByRestIdAndIdGreaterThan(restId, lastId, Pageable.ofSize(limit));
        fillNicknames(res);
        return res;
    }

    public List<RestReview> selectReviews(Long uid, int anonymous, int recommended, Long lastId, int limit) {
        final List<RestReview> res = restReviewRepository.
                findByUidAndAnonymousAndRecommendedAndIdGreaterThan(uid, anonymous, recommended, lastId, Pageable.ofSize(limit));
        fillNicknames(res);
        return res;
    }

    private void fillNicknames(List<RestReview> reviews) {
        final ArrayList<Long> uids = new ArrayList<>();
        for (final RestReview review : reviews) {
            if (review.getUid() != null) {
                uids.add(review.getUid());
            }
            for (final SubReview subReview : review.getSubReviews()) {
                if (subReview.getUid() != null) {
                    uids.add(subReview.getUid());
                }
            }
        }
        if (uids.isEmpty()) {
            return;
        }
        final List<UidNickname> uidNicknames = userService.queryUsernames(uids);
        final HashMap<Long, String> mappings = new HashMap<>();
        for (final UidNickname v : uidNicknames) {
            mappings.put(v.getUid(), v.getNickname());
        }
        for (final RestReview review : reviews) {
            review.setNickname(mappings.getOrDefault(review.getUid(), null));
            for (final SubReview subReview : review.getSubReviews()) {
                subReview.setNickname(mappings.getOrDefault(subReview.getUid(), null));
            }
        }
    }

    public boolean createSubReview(Long reviewId, Long uid, SubReview review) {
        review.setReviewId(reviewId);
        review.setUid(uid);
        subReviewRepository.save(review);
        return true;
    }

}

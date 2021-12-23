package com.example.foodwebsite.Repository;

import com.example.foodwebsite.Entity.RestReview;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestReviewRepository extends CrudRepository<RestReview, Long> {
    RestReview findRestReviewById(Long id);

    List<RestReview> findByRestIdAndIdGreaterThan(Long restId, Long lastId, Pageable pageable);

    List<RestReview> findByUidAndAnonymousAndRecommendedAndIdGreaterThan(Long uid, int anonymous, int recommended,Long lastId, Pageable pageable);
}

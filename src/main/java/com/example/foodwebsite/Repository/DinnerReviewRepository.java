package com.example.foodwebsite.Repository;

import com.example.foodwebsite.Entity.RestReview;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DinnerReviewRepository extends CrudRepository<RestReview,Long> {
List<RestReview> findAllByRestId(Long id);





}

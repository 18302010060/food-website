package com.example.foodwebsite.Repository;

import com.example.foodwebsite.Entity.DinnerReview;
import com.example.foodwebsite.Entity.RestDish;
import com.example.foodwebsite.Entity.Restaurant;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DinnerReviewRepository extends CrudRepository<DinnerReview,Long> {
List<DinnerReview> findAllByRestid(Long id);





}

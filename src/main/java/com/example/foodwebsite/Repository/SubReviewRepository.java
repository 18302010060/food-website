package com.example.foodwebsite.Repository;

import com.example.foodwebsite.Entity.SubReview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubReviewRepository extends CrudRepository<SubReview, Long> {
}

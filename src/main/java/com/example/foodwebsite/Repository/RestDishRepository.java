package com.example.foodwebsite.Repository;

import com.example.foodwebsite.Entity.RestDish;
import com.example.foodwebsite.Entity.Restaurant;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestDishRepository extends CrudRepository<RestDish,Long> {
    /*Restaurant findRestaurantByRestaurantname(String name);
    Restaurant findRestaurantByRestaurantnameAndAndLocation(String name,String location);
    List<Restaurant> findAll();
    Restaurant findRestaurantByIdrestaurant(Long id);
    List<Restaurant> findAllByRestaurantnameLike(String name);
    List<Restaurant> findAllByRestaurantnameIsLike(String name);
    @Query(value = "select * from restaurant where restaurantname =?abc" ,nativeQuery = true)
    List<Restaurant> findAllByRestaurantname(String name);

*/
    List<RestDish> findAllByRestid(Long id);
    RestDish findRestDishByRestidAndAndName(Long restId,String name);




}

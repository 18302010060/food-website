package com.example.foodwebsite.Repository;

import com.example.foodwebsite.Entity.Restaurant;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {
    /*Restaurant findRestaurantByRestaurantname(String name);
    Restaurant findRestaurantByRestaurantnameAndAndLocation(String name,String location);
    List<Restaurant> findAll();
    Restaurant findRestaurantByIdrestaurant(Long id);
    List<Restaurant> findAllByRestaurantnameLike(String name);
    List<Restaurant> findAllByRestaurantnameIsLike(String name);
    @Query(value = "select * from restaurant where restaurantname =?abc" ,nativeQuery = true)
    List<Restaurant> findAllByRestaurantname(String name);

*/
    List<Restaurant> findAllByType(int type);
    Restaurant findRestaurantById(Long id);
    Restaurant findRestaurantByAddressAndName(String address,String name);
    @Query("from Restaurant WHERE type = ?1 ORDER BY overallrating desc")
    List<Restaurant> findRestaurantbyoverallrating(int type);
    @Query("from Restaurant WHERE type = ?1 ORDER BY foodrating desc")
    List<Restaurant> findRestaurantByfoodrating(int type);
    @Query("from Restaurant WHERE type = ?1 ORDER BY servicerating desc")
    List<Restaurant> findRestaurantByservicerating(int type);
    @Query("from Restaurant WHERE type = ?1 ORDER BY ambiencerating desc")
    List<Restaurant> findRestaurantByambiencerating(int type);
    @Query("from Restaurant WHERE type = ?1 ORDER BY price ASC ")
    List<Restaurant> findRestaurantByPrice(int type);

    @Query("from Restaurant WHERE type = ?1 ORDER BY overallrating asc")
    List<Restaurant> findRestaurantByOverallratingAsc(int type);

    @Query("FROM Restaurant u WHERE (u.name LIKE CONCAT('%',:name,'%') or :name is null) AND (u.type = :type or :type = 0)")
    List<Restaurant> findRestaurantWithPartName(@Param("name") String name,@Param("type") int type);









}

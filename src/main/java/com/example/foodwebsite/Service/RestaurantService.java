
package com.example.foodwebsite.Service;
import com.example.foodwebsite.Entity.RestReview;
import com.example.foodwebsite.Entity.RestDish;
import com.example.foodwebsite.Entity.RestTag;
import com.example.foodwebsite.Entity.Restaurant;
import com.example.foodwebsite.Repository.DinnerReviewRepository;
import com.example.foodwebsite.Repository.RestDishRepository;
import com.example.foodwebsite.Repository.RestTagRepository;
import com.example.foodwebsite.Repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class RestaurantService {
    private static final int STORENUM = 6;
    private static final int RANKNUM = 15;

    Logger logger= LoggerFactory.getLogger(RestaurantService.class);
    org.slf4j.Marker marker;

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private RestTagRepository restTagRepository;
    @Autowired
    private RestDishRepository restDishRepository;
    @Autowired
    private DinnerReviewRepository dinnerReviewRepository;
    @Autowired
    private RestaurantService restaurantService;

    public List<Map<String,Object>> changeRestaurant(int type){
        List<Restaurant> restaurants = restaurantRepository.findAllByType(type);
        int size = restaurants.size();
        /*if(size <= STORENUM){
            return restaurants;
        }*/

        Random random = new Random();
        Set<Integer> num = new HashSet<>();
        List<Map<String,Object>> res = new LinkedList<>();
        while(res.size()!=6){
            int j = random.nextInt(size);
            if(num.add(j)){
                Restaurant restaurant = restaurants.get(j);
                List<String> tags = getRestaurantTags(restaurant.getId());
                Map<String,Object> map = new HashMap<>();
                map.put("Id",restaurant.getId());
                map.put("Name",restaurant.getName());
                map.put("Rate",restaurant.getOverallrating());
                map.put("BusinessHours",restaurant.getBusinesshours());
                //map.put("Raw",restaurant.getBusinesshours());
                map.put("RestTag",tags);
                res.add(map);

            }
        }
        return res;
    }

    public List<Map<String,Object>> getAllRestaurant(int type){
        List<Restaurant> restaurants = restaurantRepository.findAllByType(type);
        List<Map<String,Object>> res = new LinkedList<>();
        for(Restaurant restaurant:restaurants){
            makeReturnMessage(res, restaurant);

        }
        return res;
    }

    public List<String> getRestaurantTags(Long restaurantId){
        List<RestTag> restTag = restTagRepository.findAllByRestid(restaurantId);
        List<String> tags = new LinkedList<>();
        for(RestTag tag:restTag){
            tags.add(tag.getName());
        }
        return tags;
    }

    public Map<String,Object> getOneRestaurant(Long id){
        Restaurant restaurant = restaurantRepository.findRestaurantById(id);
        Map<String,Object> map = new HashMap<>();
        map.put("Id",restaurant.getId());
        map.put("Name",restaurant.getName());
        map.put("Rate",restaurant.getOverallrating());
        map.put("BusinessHours",restaurant.getBusinesshours());
        map.put("Raw",restaurant.getRaw());
        map.put("Address",restaurant.getAddress());
        map.put("PhoneNum",restaurant.getPhonenum());
        map.put("Price",restaurant.getPrice());
        map.put("RestTag",getRestaurantTags(restaurant.getId()));
        List<RestDish> restDishes = restDishRepository.findAllByRestid(id);
        List<Map<String,Object>> dishes = new LinkedList<>();
        for(RestDish restDish:restDishes){
            Map<String,Object> dish = new HashMap<>();
            dish.put("Name",restDish.getName());
            dish.put("Raw",restDish.getRaw());
            dish.put("Price",restDish.getPrice());
            dishes.add(dish);

        }
        map.put("RestDish",dishes);
        List<RestReview> restReviews = dinnerReviewRepository.findAllByRestId(id);
        List<Map<String,Object>> reviews = new LinkedList<>();
        for(RestReview review: restReviews){
            Map<String,Object> dinnerreview = new HashMap<>();
            dinnerreview.put("Raw",review.getRaw());
            dinnerreview.put("Recommended",review.getRecommended());
            dinnerreview.put("Anonymous",review.getAnonymous());
            dinnerreview.put("AveragePrice",review.getAveragePrice());
            dinnerreview.put("OverallRating",review.getOverallRating());
            dinnerreview.put("ServiceRating",review.getServiceRating());
            dinnerreview.put("FoodRating",review.getFoodRating());
            dinnerreview.put("AmbienceRating",review.getAmbienceRating());
            reviews.add(dinnerreview);

        }
        map.put("DinnerReview",reviews);
        return map;

    }

    public Map<String,String> addRestaurant(int type,String name,Double overallrating,Double foodrating,Double ambiencerating,Double servicerating,String BusinessHours,String raw,String Address,String PhoneNum,int price,List<RestDish> restDishList){
        Map<String,String> map = new HashMap<>();
        Restaurant restaurant = restaurantRepository.findRestaurantByAddressAndName(Address,name);
        if(restaurant!=null){
            map.put("message","店铺已存在，不可重复添加");

        }
        else{
            Restaurant newRestaurant = new Restaurant();
            newRestaurant.setType(type);
            newRestaurant.setName(name);
            newRestaurant.setBusinesshours(BusinessHours);;
            newRestaurant.setAddress(Address);
            newRestaurant.setAmbiencerating(ambiencerating);
            newRestaurant.setFoodrating(foodrating);
            newRestaurant.setOverallrating(overallrating);
            newRestaurant.setServicerating(servicerating);
            newRestaurant.setRaw(raw);
            newRestaurant.setPhonenum(PhoneNum);
            newRestaurant.setPrice(price);
            restaurantRepository.save(newRestaurant);
            map.put("message","店铺添加成功");
        }
        Restaurant restaurant1 = restaurantRepository.findRestaurantByAddressAndName(Address,name);
       /* private Long id;

        private Long restid;
        private String name;
        private int price;
        private String raw;*/
        Long restid = restaurant1.getId();
        for(RestDish restDish:restDishList){
            if(restDishRepository.findRestDishByRestidAndAndName(restid,restDish.getName())!=null){
                map.put("message2","菜品已存在，不可重复添加");
            }
            else{
                RestDish newRestDish = new RestDish();
                newRestDish.setName(restDish.getName());
                newRestDish.setRestid(restid);
                newRestDish.setPrice(restDish.getPrice());
                newRestDish.setRaw(restDish.getRaw());
                restDishRepository.save(newRestDish);
                map.put("message2","菜品添加成功");
            }

        }
        return map;



    }


    public Map<String,String> addNewDish(Long id,List<RestDish> restDishList){
        Map<String,String> map = new HashMap<>();
        for(RestDish restDish:restDishList){
            if(restDishRepository.findRestDishByRestidAndAndName(id,restDish.getName())!=null){
                /*RestDish restDish1 = new RestDish();
                restDish1.setRestid(id);
                restDish1.setName(restDish.getName());
                restDish1.setPrice(restDish.getPrice());
                restDish1.setRaw(restDish.getRaw());
                restDishRepository.save(restDish1);*/
                restDish.setRestid(id);
                restDishRepository.save(restDish);
                map.put("message","菜品添加成功");

            }
            else{
                map.put("message","菜品已存在，不可重复添加");
            }
        }
        return map;

    }


    public List<Map<String,Object>> rankRestaurant(int type,int rateType){
        List<Map<String,Object>> restaurantList = new ArrayList<>();
        List<Restaurant> restaurants = new ArrayList<>();


        switch (rateType) {
            case 1:restaurants = restaurantRepository.findRestaurantbyoverallrating(type);
                break;
            case 2:restaurants = restaurantRepository.findRestaurantByfoodrating(type);
                break;
            case 3:restaurants = restaurantRepository.findRestaurantByservicerating(type);
                break;
            case 4:restaurants = restaurantRepository.findRestaurantByambiencerating(type);
                break;
            case 5:restaurants = restaurantRepository.findRestaurantByPrice(type);//价格排序
                break;
            case 6:restaurants = restaurantRepository.findRestaurantByOverallratingAsc(type);//评分倒叙
                break;

        }

        int num = Math.min(restaurants.size(),RANKNUM);

        for(int i = 0;i<num;i++){

            Restaurant restaurant = restaurants.get(i);
            makeReturnMessage(restaurantList, restaurant);
        }
        return restaurantList;


    }

    //三者都不为空
    public List<Map<String,Object>> selectRestaurant(int type,List<String> restTag,String name){
        List<Restaurant> restaurants = restaurantRepository.findRestaurantWithPartName(name,type);

        List<Map<String,Object>> restaurantList = new ArrayList<>();

        for(Restaurant restaurant : restaurants){
            if(restTag.size()!=0){
                List<RestTag> restTags = restTagRepository.findAllByRestid(restaurant.getId());
                List<String> restTagStr = new ArrayList<>();
                for(RestTag restTag1:restTags){
                    restTagStr.add(restTag1.getName());

                }
                if(!Collections.disjoint(restTagStr,restTag)){
                    makeReturnMessage(restaurantList, restaurant);
                }
            }else{
                makeReturnMessage(restaurantList, restaurant);

            }


        }

        return restaurantList;

    }

    private void makeReturnMessage(List<Map<String, Object>> restaurantList, Restaurant restaurant) {
        Map<String,Object> res = new HashMap<>();

        res.put("Id",restaurant.getId());
        res.put("Name",restaurant.getName());
        res.put("BusinessHours",restaurant.getBusinesshours());
        res.put("Raw",restaurant.getRaw());
        res.put("Address",restaurant.getAddress());
        res.put("PhoneNum",restaurant.getPhonenum());
        res.put("Price",restaurant.getPrice());
        res.put("RestTag",getRestaurantTags(restaurant.getId()));
        restaurantList.add(res);
    }


}

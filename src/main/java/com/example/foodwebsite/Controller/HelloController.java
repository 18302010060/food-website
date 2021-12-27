package com.example.foodwebsite.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.foodwebsite.Entity.RestDish;
import com.example.foodwebsite.Service.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    RestaurantService restaurantService;

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    //换一批
    @RequestMapping("changeRestaurant")
    @ResponseBody
    public ResponseEntity<List<Map<String,Object>>> changeRestaurant(@RequestParam("type") int type){

        return ResponseEntity.ok(restaurantService.changeRestaurant(type));
    }

    //
    @RequestMapping("getAllRestaurant")
    @ResponseBody
    public ResponseEntity<List<Map<String,Object>>> getAllRestaurant(@RequestParam("type") int type){

        return ResponseEntity.ok(restaurantService.getAllRestaurant(type));
    }

    @RequestMapping("getOneRestaurant")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> getOneRestaurant(@RequestParam("id") Long id){

        return ResponseEntity.ok(restaurantService.getOneRestaurant(id));
    }

    @RequestMapping("AddRestaurant")
    @ResponseBody
    //int type,String name,Double rate,String BusinessHours,String raw,String Address,String PhoneNum,int price,List<RestDish> restDishList
    public ResponseEntity<Map<String,String>> AddRestaurant(@RequestParam("Type") int type,
                                                            @RequestParam("Name") String name,
                                                            @RequestParam("OverAllRate") Double overallRate,
                                                            @RequestParam("FoodRate") Double foodrate,
                                                            @RequestParam("AmbienceRate") Double ambiencerate,
                                                            @RequestParam("ServiceRate") Double servicerate,
                                                            @RequestParam("BusinessHours") String businessHours,
                                                            @RequestParam("Address") String address,
                                                            @RequestParam("PhoneNum") String phoneNum,
                                                            @RequestParam("Price") int price,
                                                            @RequestParam("Raw") String raw,
                                                            @RequestParam("RestDish") String restDish){
        List<RestDish>  restDishList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.parseArray(restDish);
        for(int i = 0;i<jsonArray.size();i++){
            JSONObject jsonResult = jsonArray.getJSONObject(i);
            RestDish restDish1 = JSONObject.toJavaObject(jsonResult,RestDish.class);
            restDishList.add(restDish1);
        }

        return ResponseEntity.ok(restaurantService.addRestaurant(type,name,overallRate,foodrate,ambiencerate,servicerate,businessHours,raw,address,phoneNum,price,restDishList));
    }

    /*@RequestMapping("getOneRestaurant")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> getOneRestaurant(@RequestParam("id") Long id){

        return ResponseEntity.ok(restaurantService.getOneRestaurant(id));
    }*/

    @RequestMapping("rankRestaurant")
    @ResponseBody
    public ResponseEntity<List<Map<String,Object>>> rankRestaurant(@RequestParam("Type") int type,
                                                                   @RequestParam("RateType")int rateType){

        return ResponseEntity.ok(restaurantService.rankRestaurant(type,rateType));
    }

    @RequestMapping("selectRestaurant")
    @ResponseBody
    public ResponseEntity<List<Map<String,Object>>> selectRestaurant(@RequestParam("Name") String name,
                                                                     @RequestParam("Type") int type
                                                                     //@RequestParam("RestTag") List<String> restTags
                                                                   ){
        List<String> restTags = new ArrayList<>();
        //restTags.add("好吃");
        //restTags.add("难吃");

        return ResponseEntity.ok(restaurantService.selectRestaurant(type,restTags,name));
    }







}

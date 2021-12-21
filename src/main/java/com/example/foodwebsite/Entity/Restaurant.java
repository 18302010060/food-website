package com.example.foodwebsite.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phonenum;
    private String address;
    private String businesshours;
    private int price;
    private double overallrating;
    private double foodrating;
    private double servicerating;
    private double ambiencerating;

    private String raw;//存图片
    private int type;//1.实体店 2.外卖 3.食堂

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusinesshours() {
        return businesshours;
    }

    public void setBusinesshours(String businesshours) {
        this.businesshours = businesshours;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getOverallrating() {
        return overallrating;
    }

    public void setOverallrating(double overallrating) {
        this.overallrating = overallrating;
    }

    public double getFoodrating() {
        return foodrating;
    }

    public void setFoodrating(double foodrating) {
        this.foodrating = foodrating;
    }

    public double getServicerating() {
        return servicerating;
    }

    public void setServicerating(double servicerating) {
        this.servicerating = servicerating;
    }

    public double getAmbiencerating() {
        return ambiencerating;
    }

    public void setAmbiencerating(double ambiencerating) {
        this.ambiencerating = ambiencerating;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

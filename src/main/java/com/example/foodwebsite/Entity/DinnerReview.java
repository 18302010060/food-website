package com.example.foodwebsite.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class DinnerReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long uid;
    private Long restid;
    private int anonymous;
    private int averageprice;
    private BigDecimal overallrating;
    private BigDecimal foodrating;
    private BigDecimal servicerating;
    private BigDecimal ambiencerating;
    private int recommended;
    private String raw;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRestid() {
        return restid;
    }

    public void setRestid(Long restid) {
        this.restid = restid;
    }

    public int getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(int anonymous) {
        this.anonymous = anonymous;
    }

    public int getAverageprice() {
        return averageprice;
    }

    public void setAverageprice(int averageprice) {
        this.averageprice = averageprice;
    }

    public BigDecimal getOverallrating() {
        return overallrating;
    }

    public void setOverallrating(BigDecimal overallrating) {
        this.overallrating = overallrating;
    }

    public BigDecimal getFoodrating() {
        return foodrating;
    }

    public void setFoodrating(BigDecimal foodrating) {
        this.foodrating = foodrating;
    }

    public BigDecimal getServicerating() {
        return servicerating;
    }

    public void setServicerating(BigDecimal servicerating) {
        this.servicerating = servicerating;
    }

    public BigDecimal getAmbiencerating() {
        return ambiencerating;
    }

    public void setAmbiencerating(BigDecimal ambiencerating) {
        this.ambiencerating = ambiencerating;
    }

    public int getRecommended() {
        return recommended;
    }

    public void setRecommended(int recommended) {
        this.recommended = recommended;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }
}

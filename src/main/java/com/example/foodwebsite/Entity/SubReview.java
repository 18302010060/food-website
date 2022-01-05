package com.example.foodwebsite.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.sql.Date;

@Data
@NoArgsConstructor
@Entity(name = "sub_review")
public class SubReview {
    @Id
    private Long id;
    private Long reviewId;
    private Long uid;
    private int anonymous;
    private String raw;
    private Date createAt;
    @Transient
    private String nickname;
}

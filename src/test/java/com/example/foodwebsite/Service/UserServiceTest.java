package com.example.foodwebsite.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void queryUsernames() {
        userService.queryUsernames(Arrays.asList(1L, 2L));
    }
}
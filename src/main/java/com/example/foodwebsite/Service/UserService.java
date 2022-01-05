package com.example.foodwebsite.Service;

import com.example.foodwebsite.Domain.UidNickname;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final RestTemplate restTemplate;

    public List<UidNickname> queryUsernames(List<Long> uids) {
        final ResponseEntity<UidNickname[]> res = restTemplate.
                postForEntity("http://userService/user/nicknames", uids, UidNickname[].class);
        if (res.getBody() == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(res.getBody());
    }
}

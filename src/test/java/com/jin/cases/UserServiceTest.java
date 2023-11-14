package com.jin.cases;

import com.jin.BaseTest;
import com.jin.entity.UserEntity;
import com.jin.service.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void testCount() {
        int count = userService.count(null);
        Assert.assertTrue(count > 3, "count less than 3");
    }

    @Test
    public void insertMore() {
//        prepare data
        List<UserEntity> userEntities = new ArrayList<>(5);
        long l = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            UserEntity build = UserEntity.builder()
                    .name("Yuji" + l + i)
                    .age(20 + i)
                    .email("test" + l + i + "qq.com")
                    .build();
            userEntities.add(build);
        }
        boolean b = userService.saveBatch(userEntities);
        Assert.assertTrue(b, "insert more user fail");


    }
}

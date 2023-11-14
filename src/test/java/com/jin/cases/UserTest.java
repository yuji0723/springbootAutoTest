package com.jin.cases;

import com.jin.BaseTest;
import com.jin.entity.UserEntity;
import com.jin.mapper.UserMapper;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import static org.testng.Assert.assertEquals;


public class UserTest extends BaseTest {
    
    @Autowired
    private UserMapper userMapper;


    @Test
    public void selectUser() {
        List<UserEntity> userEntities = userMapper.selectList(null);
        Assert.isTrue(5 == userEntities.size(), "user entity size error");
    }

    @Test
    public void insertUser() {
        int seconds = new Date().getSeconds();
        UserEntity userEntity = UserEntity.builder()
                .name("Beibei"+seconds).age(9).email("test"+seconds+"@qq.com")
                .build();
        int insert = userMapper.insert(userEntity);
        assertEquals(insert,1, "insert user fail");


    }

}

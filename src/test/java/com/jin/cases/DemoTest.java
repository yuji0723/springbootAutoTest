package com.jin.cases;

import com.jin.BaseTest;
import com.jin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * @author 大力pig
 * {@code @date} 2023/11/14
 **/

public class DemoTest extends BaseTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void printTest(){
        System.out.println("hello");
    }
}

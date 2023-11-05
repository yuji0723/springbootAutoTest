package com.jin.cases;

import com.jin.entity.UserEntity;
import com.jin.mapper.ProductMapper;
import com.jin.mapper.UserMapper;
import com.jin.service.domain.ProductService;
import com.jin.service.domain.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@SpringBootTest
public class DynamicTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void dynamicIServiceTest() {
        Assert.assertEquals("Jone", userService.getById(1L).getName());
        Assert.assertEquals("台灯", productService.getById(1L).getProductName());
    }

    @Test
    public void dynamicMapperTest(){
        Assert.assertEquals("Jone", userMapper.selectById(1L).getName());
        Assert.assertEquals("台灯", productMapper.selectById(1L).getProductName());
    }

}

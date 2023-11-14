package com.jin.cases;

import com.jin.BaseTest;
import com.jin.mapper.ProductMapper;
import com.jin.mapper.UserMapper;
import com.jin.service.domain.ProductService;
import com.jin.service.domain.UserService;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;


public class DynamicTest extends BaseTest {

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

    @Test
    public void countTest(){
        System.out.println(userService.getById(null));
        System.out.println(productService.getById(null));
    }

}

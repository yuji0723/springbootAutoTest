package com.jin.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping(value = "/sayHello")
    public String sayHello(String name) {
        return hello() + " " + name.trim().toLowerCase();
    }


    @ApiOperation("say hello")
    @PostMapping(value = "/sayhello2")
    public String sayHello2(@ApiParam(value = "name", name = "name", allowableValues = "pig1,pig2", required = true)
                            @RequestParam(value = "name",name = "name", required = true) String name){
        return hello() + " " + name.trim().toLowerCase();

    }
}

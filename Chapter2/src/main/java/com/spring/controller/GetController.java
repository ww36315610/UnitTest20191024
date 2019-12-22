package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

    @RequestMapping(value = "/getUser1")//默认get方法
    public String getUser1() {
        return "user1";
    }

    @RequestMapping(path = "/getUser2")      //默认get方法
    public String getUser2() {
        return "user2";
    }

    @RequestMapping(value = "/getUser3", method = {RequestMethod.GET})
    public String getUser3() {
        return "user3";
    }

    @GetMapping(value = "/getUser4")
    public String getUser4() {
        return "user4";
    }
}

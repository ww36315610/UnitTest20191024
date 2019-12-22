package com.spring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @RequestMapping(value = "/postUser1", method = {RequestMethod.POST})
    public String postUser1() {
        return "user1";
    }

    @RequestMapping(path = "/postUser2", method = {RequestMethod.POST})
    public String postUser2() {
        return "user2";
    }

    @PostMapping(value = "/postUser3")
    public String postUser3() {
        return "user3";
    }
}

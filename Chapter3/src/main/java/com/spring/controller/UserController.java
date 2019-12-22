package com.spring.controller;

import com.spring.bean.Users;
import com.spring.services.UserServices;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@Api(tags = "用户相关接口", description = "提供用户相关的 Rest API")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping("/add")
    public String addUser(String name, String pwd, String createTime) {
        String result = userServices.add(name, pwd, createTime);
        return result;
    }

    @PostMapping("/addList")
    String addList(List<Map<String, Object>> userList) {
        if (null != userList && userList.size() > 0) {
            return userServices.addList(userList);
        } else return "please check your params";
    }

    @PostMapping("/delete")
    public String deleteByName(String name) {
        String result = userServices.delete(name);
        return result;
    }

    @PostMapping("/update")
    String update(@RequestBody Users users) {
        return userServices.update(users);
    }

    @GetMapping("/get")
    Users get(Integer id) {
        if (null != id) {
            return userServices.get(id);
        } else return new Users();
    }

    @GetMapping("/getAll")
    List<Users> getAll() {
        return userServices.getAll();
    }

}

package com.spring.controller;

import com.spring.basictest.TmallApplicationTests;
import com.spring.services.UserServices;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserControllerTest extends TmallApplicationTests{
    @Autowired
    UserServices userServices;

    @Test
    public void ssTest(){
        userServices.get(1);
    }
}

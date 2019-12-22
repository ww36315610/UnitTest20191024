package com.spring.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class GetControllerTest {

    @Autowired
    GetController getController;
    @Autowired
    WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        //初始化MockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//        mockMvc = MockMvcBuilders.standaloneSetup(getController).build();
    }

    @Test
    public void getUser1() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/getUser1");
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println("getUser1-----------------------" + mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getUser2() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/getUser3");
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println("getUser2-----------------------" + mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getUser3() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/getUser3");
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println("getUser3-----------------------" + mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getUser4() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/getUser4");
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println("getUser4-----------------------" + mvcResult.getResponse().getContentAsString());
    }
}
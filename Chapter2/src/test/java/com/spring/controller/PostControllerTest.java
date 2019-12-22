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
public class PostControllerTest {

    @Autowired
    PostController postController;
    @Autowired
    WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        //初始化MockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//        mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
    }


    @Test
    public void postUser1() throws Exception {
        request = getMockHttpRequest("postUser1");
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println("postUser1-----------------------" + mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void postUser2() throws Exception {
        request = getMockHttpRequest("postUser2");
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println("postUser2-----------------------" + mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void postUser3() throws Exception {
        request = getMockHttpRequest("postUser3");
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println("postUser3-----------------------" + mvcResult.getResponse().getContentAsString());
    }

    /**
     * 获取：MockHttpServletRequestBuilder
     */
    MockHttpServletRequestBuilder request;

    public MockHttpServletRequestBuilder getMockHttpRequest(String methodName) {
        if (methodName.equals("postUser1")) {
            request = MockMvcRequestBuilders.post("/postUser1");
        } else if (methodName.equals("postUser2")) {
            request = MockMvcRequestBuilders.post("/postUser2");
        } else if (methodName.equals("postUser3")) {
            request = MockMvcRequestBuilders.post("/postUser3");
        }
        return request;
    }
}
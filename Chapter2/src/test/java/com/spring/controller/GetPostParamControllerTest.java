package com.spring.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.bean.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class GetPostParamControllerTest {

    @Autowired
    GetPostParamController getPostParamController;
    @Autowired
    WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        //初始化MockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//        mockMvc = MockMvcBuilders.standaloneSetup(getPostParamController).build();
    }

    @Test
    public void getUserParam() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/getUserParam").param("id", "111");
        MvcResult mvcResult = null;
        mvcResult = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();
        System.out.println("Test is :" + mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void postUserParam() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/postUserParam")
                .param("name", "name")
                .param("pwd", "pwd");
        MvcResult mvcResult = null;
        mvcResult = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();
        System.out.println("Test is :" + mvcResult.getResponse().getContentAsString());
    }


    @Test
    public void postUserBody() {
        Order order = new Order();
        order.setId(1);
        order.setName("postName");
        order.setPwd("postPwd");
        order.setPrice(110);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/postUserBody");
        MvcResult mvcResult = null;
        try {
            mvcResult = mockMvc.perform(request.contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(order)))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(print())
                    .andReturn();
            String result = mvcResult.getResponse().getContentAsString();
            Assert.assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试上传方法
     * @throws Exception
     */
    @Test
    public void file() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.fileUpload("/file")
                .file(new MockMultipartFile("file", "test.txt",
                        "multipart/form-data",
                        "hello upload".getBytes("UTF-8"))))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assert.assertEquals("file", result);
    }
}